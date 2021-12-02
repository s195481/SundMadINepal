package com.example.sundmadinepal.model.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Recipe(
    val id: String,
    val name: String?,
    val ingredients: String?,
    val procedure: String?,
    val picture: String?
)
