package com.example.sundmadinepal.model.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sundmadinepal.model.model.Recipe
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Database(
    version = 3,
    entities = [RecipeEntity::class],
    autoMigrations = [
        AutoMigration (from = 1, to = 2),
        AutoMigration (from = 2, to = 3)
    ],
    exportSchema = true

)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
    fun RecipeGeneratorThing() {
        val assetDao = recipeDao()
        val recipe1: Recipe = Recipe(
            id = "Dahl_v1",
            name = "Dahl_v1",
            ingredients = "Beans 1",
            procedure = "Cook 1",
            picture = "",
            pictureID = 34
        )
        val recipe1x: RecipeEntity = (recipe1.toEntity())
        fun recipestuff() = runBlocking { // this: CoroutineScope
            launch {
                assetDao.insert(recipe1x)
            }
        }
        recipestuff()
    }


    companion object {
        fun build(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "golden-days")

                .build()
        }

    }


}