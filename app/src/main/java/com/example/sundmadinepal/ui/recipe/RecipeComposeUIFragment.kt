package com.example.sundmadinepal.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme.typography
import com.example.sundmadinepal.model.model.Recipe
import com.example.sundmadinepal.ui.recipe.RecipeViewModel.DataProvider.recipeList

class RecipeComposeUIFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Recipes()

            }
        }
    }
}



@Composable
fun Recipes(/* Can't remember what these guys are for "state: String, onValueChange: (String) -> Unit"*/) {
    val recipies = remember { RecipeViewModel.DataProvider.recipeList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = recipies,
            itemContent = {
                RecipeListItem(recipe = it)
            })
    }
}

@Composable
fun RecipeListItem(recipe: Recipe) {
    Row {
        Column {
            Text(text = recipe.name, style = typography.h6)
            Text(text = recipe.id, style = typography.caption)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //Greeting("Android")
        Recipes()
    }
}