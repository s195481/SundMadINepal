package com.example.sundmadinepal.ui.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.sundmadinepal.model.model.Recipe

@Composable
fun RecipeScreen(recipe: Recipe) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    RecipeHeader(
                        recipe = recipe,
                        containerHeight = this@BoxWithConstraints.maxHeight,
                    )
                }
            }
        }
    }
}

@Composable
private fun RecipeHeader(
    recipe: Recipe,
    containerHeight: Dp,
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(recipe.pictureID),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}