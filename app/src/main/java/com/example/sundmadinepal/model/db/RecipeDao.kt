package com.example.sundmadinepal.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe WHERE id = :id")
    fun loadById(id: String): Flow<RecipeEntity?>

    @Query("SELECT * FROM recipe")
    fun loadAll(): List<RecipeEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(asset: RecipeEntity)
}