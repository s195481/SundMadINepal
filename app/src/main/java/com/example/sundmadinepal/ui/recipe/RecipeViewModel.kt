package com.example.sundmadinepal.ui.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.R
import com.example.sundmadinepal.model.db.AppDatabase
import com.example.sundmadinepal.model.model.Recipe

class RecipeViewModel(private val db: AppDatabase) : ViewModel() {

    fun getRecipes() {
        val recipeList = listOf(
            db.recipeDao().loadById("Dahl_v1"),
        )
    }

    object DataProvider {
        val recipeList = listOf(
            Recipe(
                id = "jaulo",
                name = "Jaulo",
                ingredients = "",
                procedure = "\n" +
                        "        \nIngredients:\n" +
                        "        \n●\tRice\t25 gram\n" +
                        "        \n●\tMung / pink lentil / split yellow pigeon peas / black gram lentil\t8 gram\n" +
                        "        \n●\tClarified butter or oil 5 gram\n" +
                        "        \n●\tGreen spinach (saag) according to taste\n" +
                        "        \n\n" +
                        "        \nDirection:\n" +
                        "        \n●\tClean rice and lentils.\n" +
                        "        \n●\tMix rice and lentil together and soak for half an hour after washing.\n" +
                        "        \n●\tAfter half an hour, cook in a pan covering with lid using a bit of clarified butter and water.\n" +
                        "        \n●\tWhile porridge is being cooked, add finely chopped green spinach and cook further covering with lid.\n" +
                        "        \n●\tAdd iodized salt for taste.",
                picture = "jaulo",
                pictureID = R.drawable.p0
            ),
            Recipe(
                id = "nutritionalflour",
                name = "Flour",
                ingredients = "",
                procedure = "\n" +
                        "        How to prepare nutritional flour:\n" +
                        "        \nTake 2 proportions of different types of grains (corn, barley, rye, millet, oat, rice, etc. one proportio each)\n" +
                        "        and 1 proportion of cereals/lentils (soya, chickpeas, peas, etc). Separately sort/clean and dry roast well until\n" +
                        "        cooked properly and then separately grind store. This flour can be cooked with green spinach, carrot ,milk, clarified butter,\n" +
                        "        honey , eggs, meat, and iodized salt.",
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