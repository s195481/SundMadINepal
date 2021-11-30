package com.example.sundmadinepal.model;

import com.example.sundmadinepal.model.api.RecipeApi
import com.example.sundmadinepal.model.api.model.RecipeDto
import com.example.sundmadinepal.model.api.model.toEntity
import com.example.sundmadinepal.model.db.*
import com.example.sundmadinepal.model.model.Recipe
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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

        val assetDao = database.recipeDao()
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

    fun RecipeGeneratorThing() {
        val assetDao = database.recipeDao()
        val recipe1: Recipe = Recipe(
            id = "Dahl_v1",
            name = "Dahl_v1",
            ingredients = "Beans 1",
            procedure = "Cook 1",
            picture = ""
        )
        val recipe1x: AssetRecipe = (recipe1.toEntity())
        fun recipestuff() = runBlocking { // this: CoroutineScope
            launch {
                assetDao.insert(recipe1x)
            }
        }
        recipestuff()

        /*
        val recipeList = listOf(
            ,
            Recipe(
                id = "Dahl_v2",
                name = "Dahl_v2",
                ingredients = "Beans 2",
                procedure = "Cook 2",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v3",
                name = "Dahl_v3",
                ingredients = "Beans 3",
                procedure = "Cook 3",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v4",
                name = "Dahl_v4",
                ingredients = "Beans 4",
                procedure = "Cook 4",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v5",
                name = "Dahl_v5",
                ingredients = "Beans 5",
                procedure = "Cook 5",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v6",
                name = "Dahl_v6",
                ingredients = "Beans 6",
                procedure = "Cook 6",
                picture = ""
            )
        )*/
    }
}
