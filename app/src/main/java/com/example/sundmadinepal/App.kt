package com.example.sundmadinepal

import android.app.Application
import android.util.Log
import com.example.sundmadinepal.di.ServiceLocator
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Locale.setDefault(Locale("da", "DK"))
        ServiceLocator.init(this)
        ServiceLocator.db.RecipeGeneratorThing()
        Log.e("Check", ServiceLocator.db.recipeDao().loadById("Dahl_v1").toString())
        Log.d("HERE", "I AM HERE")
    }
}