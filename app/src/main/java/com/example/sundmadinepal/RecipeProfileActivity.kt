package com.example.sundmadinepal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import com.example.sundmadinepal.model.model.Recipe
import com.example.sundmadinepal.ui.recipe.RecipeScreen

class RecipeProfileActivity : AppCompatActivity() {
    var PACKAGE_NAME: String? = null

    private val recipe : Recipe by lazy {
        intent?.getSerializableExtra(RECIPE_ID) as Recipe
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            RecipeScreen(recipe = recipe)
        }
    }

    companion object {
        private const val RECIPE_ID = "recipe_id"
        fun newIntent(context: Context, recipe: Recipe) =
            Intent(context,RecipeProfileActivity::class.java).apply {
                putExtra(RECIPE_ID,recipe)

        }
    }
}