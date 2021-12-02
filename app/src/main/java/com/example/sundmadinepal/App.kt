package com.example.sundmadinepal

import android.app.Application
import android.util.Log
import com.example.sundmadinepal.di.ServiceLocator
import com.example.sundmadinepal.model.db.RecipeEntity
import com.example.sundmadinepal.ui.healthPost.temp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.onEach

import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Locale.setDefault(Locale("da", "DK"))
        ServiceLocator.init(this)
        ServiceLocator.db.RecipeGeneratorThing()
        val list = ServiceLocator.db.recipeDao().loadById("Dahl_v1")
        list[0]

        Log.d("HERE", "I AM HERE")

    }
}
