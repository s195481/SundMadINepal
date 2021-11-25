package com.example.sundmadinepal

import android.app.Application
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Locale.setDefault(Locale("da", "DK"))
    }
}