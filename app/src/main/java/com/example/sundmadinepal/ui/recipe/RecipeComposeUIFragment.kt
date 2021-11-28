package com.example.sundmadinepal.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.sundmadinepal.R
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
    val recipes = remember { RecipeViewModel.DataProvider.recipeList }
    Column() {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.recipes),
                contentDescription = "Recipes",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "Recipes",
                //modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = recipes,
                itemContent = {
                    RecipeListItem(recipe = it)
                })
        }
    }
}

@Composable
fun RecipeListItem(recipe: Recipe) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.
        fillMaxSize().
        padding(8.dp).
        clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().
            background(Color.LightGray)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = recipe.id,
                modifier = Modifier.size(50.dp).apply { padding(70.dp) }
            )
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