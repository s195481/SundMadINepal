package com.example.sundmadinepal.ui.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.di.ServiceLocator.recipeRepository
import com.example.sundmadinepal.model.AssetRepository
import com.example.sundmadinepal.model.model.Recipe

class RecipeViewModel(private val recipeRepository: AssetRepository) : ViewModel() {
    fun getRecipes() {
        val recipeList = listOf(
            recipeRepository.getAsset("Dahl_v1"),
            recipeRepository.getAsset("Dahl_v1")
        )
    }


    object DataProvider {
        val recipeList = listOf(
            //ServiceLocator.recipeRepository.getAsset("Dahl_v1")
            Recipe(
                id = "Dahl_v1",
                name = "Dahl_v1",
                ingredients = "Beans 1",
                procedure = "Cook 1",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v2",
                name = "Dahl_v2",
                ingredients = "Beans 2",
                procedure = "Cook 2",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v3",
                name = "Dahl_v3",
                ingredients = "Beans 3",
                procedure = "Cook 3",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v4",
                name = "Dahl_v4",
                ingredients = "Beans 4",
                procedure = "Cook 4",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v5",
                name = "Dahl_v5",
                ingredients = "Beans 5",
                procedure = "Cook 5",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v6",
                name = "Dahl_v6",
                ingredients = "Beans 6",
                procedure = "Cook 6",
                picture = ""
            ),
            // TODO recipeRepository.getAsset("Dahl_v1"),
            recipeRepository.getAsset("Dahl_v1"),
        )
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}