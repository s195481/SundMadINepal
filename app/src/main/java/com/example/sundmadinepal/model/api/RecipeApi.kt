package com.example.sundmadinepal.model.api

import com.example.sundmadinepal.model.api.model.RecipeDto
import retrofit2    .Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeApi {
    @GET("recipes")
    fun getRecipes(): Call<List<RecipeDto>>

    @GET("recipes/{id}")
    suspend fun getRecipe(@Path("id") id: String): RecipeDto
}