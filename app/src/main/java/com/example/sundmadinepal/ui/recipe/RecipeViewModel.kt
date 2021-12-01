package com.example.sundmadinepal.ui.recipe

import android.content.res.Resources
import androidx.compose.ui.res.stringResource
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.R
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
        val resources: Resources = Resources.getSystem()
        val recipeList = listOf(
            //ServiceLocator.recipeRepository.getAsset("Dahl_v1")
            Recipe(
                id = resources.getString(R.string.jaulo_title_string),
                name = Resources.getSystem().getString(R.string.jaulo_title_string),
                ingredients = "",
                procedure = Resources.getSystem().getString(R.string.jaulo_string),
                picture = "jaulo"
            ),
            Recipe(
                id = Resources.getSystem().getString(R.string.nutritionalflour_title_string),
                name = Resources.getSystem().getString(R.string.nutritionalflour_title_string),
                ingredients = "",
                procedure = Resources.getSystem().getString(R.string.nutritionalflour_string),
                picture = "nutritionalflour"
            )/*,
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
            ),*/
            // TODO recipeRepository.getAsset("Dahl_v1"),
            // recipeRepository.getAsset("Dahl_v1"),
        )
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}