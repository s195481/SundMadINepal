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
    @ColumnInfo(name = "picture") val picture: String
)

fun RecipeEntity.toModel(): Recipe = Recipe(id, name, ingredients, procedure, picture)

fun Recipe.toEntity(): RecipeEntity = RecipeEntity(id, name, ingredients, procedure, picture)