package com.example.sundmadinepal

import android.app.Application
import dk.shortcut.dtudemoapp.di.ServiceLocator
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this)
        Locale.setDefault(Locale("da", "DK"))
    }
}