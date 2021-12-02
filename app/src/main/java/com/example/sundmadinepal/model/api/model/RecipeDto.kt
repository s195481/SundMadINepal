package com.example.sundmadinepal.model.api.model

import com.example.sundmadinepal.model.db.RecipeEntity
import com.example.sundmadinepal.model.model.Recipe
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeDto(
    val id: String,
    val name: String = "",
    val ingredients: String = "",
    val procedure: String = "",
    val picture: String = "",
    val pictureID: Int = 0
)

fun RecipeDto.toModel() = Recipe(id, name, ingredients, procedure, picture)
fun RecipeDto.toEntity() = RecipeEntity(id, name, ingredients, procedure, picture)
