package com.example.sundmadinepal.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get
import com.example.sundmadinepal.facilitator.permission.PermissionFacilitator
import com.example.sundmadinepal.ui.MainViewModel
import com.example.sundmadinepal.ui.comics.ComicsViewModel
import com.example.sundmadinepal.ui.goldenDays.GoldenDaysViewModel
import com.example.sundmadinepal.ui.health.HealthViewModel
import com.example.sundmadinepal.ui.recipe.RecipeViewModel

object ServiceLocator {

    private lateinit var application: Application

    fun init(application: Application) {
        ServiceLocator.application = application
    }


    //TODO Hvad fuck er det her

    // Effectively singleton
    private val viewModelFactory by lazy {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return when (modelClass) {
                    MainViewModel::class.java -> MainViewModel()
                    GoldenDaysViewModel::class.java -> GoldenDaysViewModel()
                    RecipeViewModel::class.java -> RecipeViewModel()
                    HealthViewModel::class.java -> HealthViewModel()
                    ComicsViewModel::class.java -> ComicsViewModel()
                    else -> throw IllegalArgumentException("Unsupported ViewModel $modelClass")
                } as T
            }
        }
    }

    // Effectively singleton
    val permissionFacilitator: PermissionFacilitator by lazy {
        PermissionFacilitator(application)
    }

    val ViewModelStoreOwner.mainViewModel: MainViewModel
        get() = ViewModelProvider(this, viewModelFactory).get()

    val ViewModelStoreOwner.goldenDaysViewModel: GoldenDaysViewModel
        get() = ViewModelProvider(this, viewModelFactory).get()

    val ViewModelStoreOwner.recipeViewModel: RecipeViewModel
        get() = ViewModelProvider(this, viewModelFactory).get()

    val ViewModelStoreOwner.healthViewModel: HealthViewModel
        get() = ViewModelProvider(this, viewModelFactory).get()

    val ViewModelStoreOwner.comicsViewModel: ComicsViewModel
        get() = ViewModelProvider(this, viewModelFactory).get()
}