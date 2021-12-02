package com.example.sundmadinepal.ui.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
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
                    RecipeContent(
                        recipe = recipe,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )
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
    Text(text = recipe.procedure)
}

@Composable
private fun RecipeContent(
    recipe: Recipe,
    containerHeight: Dp
) {
    val navController = rememberNavController()
    Column()
    {
        val titlePadding: Int = 100 / 10
        val backButtonSize: Int = 100 / 2
        Row(
            modifier = Modifier
                .background(colorResource(R.color.Recipe_Icon))
        ) {
            if (false) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(titlePadding.dp),
                ) {
                    IconButton(modifier = Modifier.then(Modifier.size(backButtonSize.dp)),
                        onClick = {
                            navController.popBackStack()
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.backbutton),
                            "backbutton",
                            modifier = Modifier.size(backButtonSize.dp)
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Icon(
                    painter = painterResource(R.drawable.recipes),
                    contentDescription = recipe.name,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(titlePadding.dp)
                )
                Text(
                    text = recipe.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(titlePadding.dp),
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}