package com.example.sundmadinepal.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sundmadinepal.model.model.Recipe

@Entity(tableName = "recipe")
data class AssetRecipe(
    @PrimaryKey val id: String,
    val name: String,
    val ingredients: String,
    val procedure: String,
    val picture: String
)

fun AssetRecipe.toModel(): Recipe = Recipe(id, name, ingredients, procedure, picture)

fun Recipe.toEntity(): AssetRecipe = AssetRecipe(id, name, ingredients, procedure, picture)