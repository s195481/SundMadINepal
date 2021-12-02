package com.example.sundmadinepal.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sundmadinepal.model.model.Recipe

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "procedure") val procedure: String,
    @ColumnInfo(name = "picture") val picture: String,
    @ColumnInfo(name = "pictureID", defaultValue = "0") val pictureID: Int = 0
)

fun RecipeEntity.toModel(): Recipe = Recipe(id, name, ingredients, procedure, picture, pictureID)

fun Recipe.toEntity(): RecipeEntity = RecipeEntity(id, name, ingredients, procedure, picture, pictureID)