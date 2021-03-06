package com.example.sundmadinepal

import android.app.Application
import com.example.sundmadinepal.di.ServiceLocator
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Locale.setDefault(Locale("da", "DK"))
        ServiceLocator.init(this)
        ServiceLocator.db.RecipeGeneratorThing()
    }
}