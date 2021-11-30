package com.example.sundmadinepal

import android.app.Application
import com.example.sundmadinepal.di.ServiceLocator
import com.example.sundmadinepal.model.AssetRepository
import com.example.sundmadinepal.model.api.RecipeApi
import com.example.sundmadinepal.model.api.model.RecipeDto
import com.example.sundmadinepal.model.db.AppDatabase
import com.example.sundmadinepal.model.db.AssetRecipe
import com.example.sundmadinepal.model.db.RecipeDao
import com.example.sundmadinepal.model.db.toEntity
import com.example.sundmadinepal.model.model.Recipe
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Locale.setDefault(Locale("da", "DK"))
        ServiceLocator.init(this)
        // TODO Probably delete stuff below later on
        val database: AppDatabase = AppDatabase.build(this)
        //val recipeApi: RecipeApi = RecipeApi

        //AssetRepository(database,recipeApi).RecipeGeneratorThing()
    }
}