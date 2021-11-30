package com.example.sundmadinepal.model;

import com.example.sundmadinepal.model.api.RecipeApi
import com.example.sundmadinepal.model.api.model.RecipeDto
import com.example.sundmadinepal.model.api.model.toEntity
import com.example.sundmadinepal.model.db.AppDatabase
import com.example.sundmadinepal.model.db.toModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.io.IOException

class AssetRepository(
    private val recipeApi: RecipeApi,
    private val database: AppDatabase
) {
    private val _refreshTrigger = MutableStateFlow("" to -1L)

    /**
     * The only responsibility of this function is to increase the trigger count.
     */
    fun refresh(id: String) {
        val (_, currentCount) = _refreshTrigger.value
        _refreshTrigger.value = _refreshTrigger.value.copy(id, currentCount + 1)
    }



    fun getAsset(id: String): Flow<Unit> {
        refresh(id)

        val assetDao = database.assetDao()
        return assetDao.loadById(id)
            .combine(_refreshTrigger.filter { (refreshId, _) -> refreshId == id }, ::Pair)
            .mapLatest { (entity, refreshTrigger) ->
                val (_, triggerCount) = refreshTrigger
                if (entity == null || triggerCount > 0L) {
                    // Doesn't exist in Database, fetch from API
                    val dbAsset = flow { emit(recipeApi.getRecipe(id)) }
                        .retryWhen { cause, attempt ->
                            if (cause is IOException && attempt < 3) {
                                // Exponential backoff
                                delay((attempt + 1) * (attempt + 1) * 1000)
                                return@retryWhen true
                            } else {
                                return@retryWhen false
                            }
                        }
                        .catch { emit(RecipeDto(id)) }
                        .first()
                        .toEntity()
                    assetDao.insert(dbAsset)
                    return@mapLatest dbAsset to triggerCount
                } else {
                    // Exists; return a repository mapped instance
                    return@mapLatest entity to triggerCount
                }
            }
            .onEach { (_, currentCount) ->
                if (currentCount > 0L) {
                    // Force refresh requires the trigger count to be > 0, thus needs to be reset.
                    // Otherwise the first force refresh will trigger a loop of force refresh calls
                    // to the API, causing a DDOS-attack 😃
                    _refreshTrigger.value = _refreshTrigger.value.copy(second = 0L)
                }
            }
            .map { (entity, _) -> entity.toModel() }
    }
}
