package com.example.sundmadinepal.ui.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.R
import com.example.sundmadinepal.di.ServiceLocator
import com.example.sundmadinepal.model.db.toModel
import com.example.sundmadinepal.model.model.Recipe
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class RecipeViewModel() : ViewModel() {

    object DataProvider {
        suspend fun dbWork() = coroutineScope {
            launch {
                val recipes = ServiceLocator.db.recipeDao().loadAll()
                for (i in 0..recipes.count()) {
                    Log.e("DB_check", recipes[i].toString())
                    recipes[i]?.let { recipeList.add(it.toModel()) }
                    recipes[i]?.pictureID ?: R.drawable.p0
                }
            }
        }


        val recipeList = mutableListOf(

            //ServiceLocator.recipeRepository.getAsset("Dahl_v1")
            // TODO Har lige lavet alt nedunder til Strings - bare så det kan blive loaded og der kan laves UI
            Recipe(
                id = "jaulo",
                name = "Jaulo",
                ingredients = "",
                procedure = "jaulo",
                picture = "jaulo",
                pictureID = R.drawable.p0
            ),
            Recipe(
                id = "nutritionalflour",
                name = "Flour",
                ingredients = "",
                procedure = "nutritionalflour",
                picture = "nutritionalflour",
                pictureID = R.drawable.p1
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