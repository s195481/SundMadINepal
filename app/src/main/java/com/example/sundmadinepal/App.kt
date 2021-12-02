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
        //ServiceLocator.db.RecipeGeneratorThing()
        //val list = ServiceLocator.db.recipeDao().loadAll()
        //Log.e("DB_Check", list[0].toString())

        Log.d("HERE", "I AM HERE")
    }
}