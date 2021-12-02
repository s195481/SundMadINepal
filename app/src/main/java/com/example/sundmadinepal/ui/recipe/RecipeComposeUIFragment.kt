package com.example.sundmadinepal.ui.recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
import com.example.sundmadinepal.model.model.Recipe
import com.example.sundmadinepal.ui.recipe.RecipeViewModel.DataProvider.Recipes
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme
import com.example.sundmadinepal.ui.utils.TopBarGenerator
import kotlinx.coroutines.runBlocking

class RecipeComposeUIFragment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        val navController = rememberNavController()
        //RecipesComposable(navController)
    }
}

@Composable
fun RecipesComposable(navController: NavController, navigateToProfile: (Recipe) -> Unit) {
    //val recipes2 = remember { RecipeViewModel().getRecipes()}
    fun co() = runBlocking {
        Recipes()
    }
    val recipes = remember { RecipeViewModel.DataProvider.recipeList }
    Column(
        Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.Home_Col)),
    ) {
        TopBarGenerator(
            navController,
            R.drawable.recipes,
            stringResource(R.string.title_recipe),
            100,
            backButtonBool = true,
            color = R.color.Recipe_Icon
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = recipes,
                itemContent = {
                    RecipeListItem2(navController = navController, recipe = it, navigateToProfile)
                })
        }
    }
}

@Composable
fun RecipeListItem(navController: NavController, recipe: Recipe) {
    val imageSize: Int = 220
    val imagePadding: Int = 0
    Row(
        modifier = Modifier.padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {
                // TODO Fix should be recipe.id
                //navController.navigate("recipeDetailed")
            },
            modifier = Modifier
                .apply { padding(imagePadding.dp) }
                .size(imageSize.dp)
                .clip(CircleShape)
                .border(1.5.dp, colorResource(id = R.color.Border_Col), CircleShape)
                .background(Color.White)
        ) {
            if (recipe.picture == "jaulo") {
                Image(
                    painter = painterResource(R.drawable.p0),
                    contentDescription = recipe.id
                )
            } else if (recipe.picture == "nutritionalflour") {
                Image(
                    painter = painterResource(R.drawable.p1),
                    contentDescription = recipe.id
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.information),
                    contentDescription = recipe.id
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun RecipeListItem2(navController: NavController, recipe: Recipe, navigateToProfile: (Recipe) -> Unit) {
    val imageSize: Int = 220
    val imagePadding: Int = 0
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth().clickable { navigateToProfile(recipe)},
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row{
            //Modifier.clickable { navigateToProfile(recipe)}
            //Image
            Image(
                painter = painterResource(recipe.pictureID),
                contentDescription = recipe.id,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(8.dp).size(84.dp).clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
            /*
            if (recipe.picture == "p0") {

            } else if (recipe.picture == "p1") {
                Image(
                    painter = painterResource(R.drawable.p1),
                    contentDescription = recipe.id,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(8.dp).size(84.dp).clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.information),
                    contentDescription = recipe.id,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(8.dp).size(84.dp).clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                )
            }

             */
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ){
                //
                 Text(text = recipe.name, style = typography.h6)
                Text(text = "VIEW DETAIL", style = typography.caption)
            }
        }
    }
}

@Composable
fun RecipeDetailedComposable(navController: NavController) {
    RecipeComposableGenerator(
        navController = navController,
        title = R.string.jaulo_title_string,
        picture = R.drawable.p0,
        breadText = R.string.jaulo_string
    )
}

@Composable
fun RecipeComposableGenerator(
    navController: NavController,
    title: Int,
    picture: Int,
    breadText: Int
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.recipes,
            title = stringResource(title),
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Recipe_Icon
        )
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(picture),
                contentDescription = stringResource(title),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .padding(10.dp)
            )
            Text(
                text = stringResource(id = breadText),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}
