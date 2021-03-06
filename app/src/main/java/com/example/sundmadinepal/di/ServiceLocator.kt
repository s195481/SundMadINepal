package com.example.sundmadinepal.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get
import com.example.sundmadinepal.facilitator.permission.PermissionFacilitator
import com.example.sundmadinepal.model.db.AppDatabase
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

    val db: AppDatabase by lazy { AppDatabase.build(application) }
    /*
    val database: AppDatabase by lazy { AppDatabase.build(application) }

    val recipeRepository: AssetRepository by lazy {
        AssetRepository(recipeApi, database)
    }
    private val recipeApi: RecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://dadadadadadadadadadadadadadadadadadadadadada.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        chain.request().newBuilder()
                            .addHeader(
                                "user",
                                "temporary"
                            )
                            .build()
                            .let { chain.proceed(it) }
                    }
                    .addInterceptor(
                        HttpLoggingInterceptor { Log.e("ServiceLocator", it) }
                            .also { it.level = HttpLoggingInterceptor.Level.BODY }
                    )
                    .build()
            )
            .addConverterFactory(WrapperConverter())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }*/


    // Effectively singleton
    private val viewModelFactory by lazy {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return when (modelClass) {
                    MainViewModel::class.java -> MainViewModel()
                    GoldenDaysViewModel::class.java -> GoldenDaysViewModel()
                    RecipeViewModel::class.java -> RecipeViewModel(db)
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