package com.example.sundmadinepal.di

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get
import com.example.sundmadinepal.facilitator.permission.PermissionFacilitator
import com.example.sundmadinepal.model.AssetRepository
import com.example.sundmadinepal.model.api.RecipeApi
import com.example.sundmadinepal.model.api.WrapperConverter
import com.example.sundmadinepal.model.db.AppDatabase
import com.example.sundmadinepal.ui.MainViewModel
import com.example.sundmadinepal.ui.comics.ComicsViewModel
import com.example.sundmadinepal.ui.goldenDays.GoldenDaysViewModel
import com.example.sundmadinepal.ui.health.HealthViewModel
import com.example.sundmadinepal.ui.recipe.RecipeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object ServiceLocator {

    private lateinit var application: Application

    fun init(application: Application) {
        ServiceLocator.application = application
    }

    val database : AppDatabase by lazy { AppDatabase.build(application) }

    private val recipeApi : RecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://dadadadadadadadadadadadadadadadadadadadadada.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor{ chain -> chain.request().newBuilder()
                    .addHeader(
                        "user",
                        "temporary"
                    )
                        .build()
                        .let{ chain.proceed(it)}
                    }
                    .addInterceptor(
                        HttpLoggingInterceptor { Log.e("ServiceLocator",it) }
                            .also { it.level = HttpLoggingInterceptor.Level.BODY }
                    )
                    .build()
            )
            .addConverterFactory(WrapperConverter())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }


    //TODO Hvad fuck er det her

    // Effectively singleton
    private val viewModelFactory by lazy {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return when (modelClass) {
                    MainViewModel::class.java -> MainViewModel()
                    GoldenDaysViewModel::class.java -> GoldenDaysViewModel()
                    RecipeViewModel::class.java -> RecipeViewModel(recipeRepository)
                    HealthViewModel::class.java -> HealthViewModel()
                    ComicsViewModel::class.java -> ComicsViewModel()
                    else -> throw IllegalArgumentException("Unsupported ViewModel $modelClass")
                } as T
            }
        }
    }

    val recipeRepository : AssetRepository by lazy{
        AssetRepository(recipeApi,database)
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