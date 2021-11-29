package com.example.sundmadinepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.model.model.Comics
import com.example.sundmadinepal.model.model.GoldenDays
import com.example.sundmadinepal.model.model.Recipe
import com.example.sundmadinepal.ui.comics.ComicsViewModel
import com.example.sundmadinepal.ui.goldenDays.GoldenDaysViewModel
import com.example.sundmadinepal.ui.recipe.RecipeViewModel
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { MainComposable(navController) }
                composable("recipe") { RecipesComposable(navController) }
                composable("goldenDays") { GoldenDaysComposable(navController) }
                composable("comics") { ComicsComposable(navController) }
                composable("health") { HealthComposable(navController) }
                composable("healthPost") {HealthPostComposable(navController)}
            }
            //MainComposable(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        val navController = rememberNavController()
        MainComposable(navController)
    }
}

@Composable
fun MainComposable(navController: NavController) {
    val navIconSize: Int = 170
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "Home",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        Row(
        ) {
            IconButton(modifier = Modifier
                .then(Modifier.size(navIconSize.dp))
                .background(color = Color.Green),
                onClick = {
                    navController.navigate("goldenDays")
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.newborn),
                    "1000GoldenDays",
                    tint = Color.Magenta,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {
                    navController.navigate("recipes")
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.recipes),
                    "Recipes",
                    tint = Color.LightGray,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
        }
        Row() {
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {
                    navController.navigate("comics")
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.comic),
                    "Comics",
                    tint = Color.Yellow,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    painter = painterResource(id = R.drawable.quiz),
                    "quiz",
                    tint = Color.Green,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
        }
        Row() {
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    painter = painterResource(id = R.drawable.health_post),
                    "healthPost",
                    tint = Color.Cyan,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {
                    navController.navigate("health")
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.baby),
                    "Health",
                    tint = Color.Red,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
        }
    }
}


@Composable
fun GoldenDaysComposable(navController: NavController) {
    val goldenDays = remember { GoldenDaysViewModel.DataProvider.goldenDaysList }
    Column() {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.newborn),
                contentDescription = "GoldenDays",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "1000 Golden Days",
                //modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = goldenDays,
                itemContent = {
                    GoldenDaysListItem(goldenDays = it)
                })
        }
    }
}

@Composable
fun GoldenDaysListItem(goldenDays: GoldenDays) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = goldenDays.goldenDayPeriod,
                modifier = Modifier.size(50.dp).apply { padding(70.dp) }
            )
            Text(text = goldenDays.goldenDayPeriod, style = MaterialTheme.typography.h6)
            Text(text = goldenDays.goldenDayTex, style = MaterialTheme.typography.caption)

        }
    }
}

@Composable
fun HealthComposable(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
            onClick = { }) {
            Icon(
                Icons.Filled.ArrowBack,
                "contentDescription",
                tint = Color.Red
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.temp),
            contentDescription = "Temp",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "Health"
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(24.dp)
            .background(Color.Yellow)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.temp),
            contentDescription = "Kid",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "name"
        )
        Text(
            text = "dd/mm/yyyy"
        )
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Height: "
            )
            Text(
                text = "55 cm"
            )
        }
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Weight: "
            )
            Text(
                text = "5 kg"
            )
        }
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Diary: "
            )
            Text(
                text = "Only eaten breastmilk so far."
            )
        }
    }
}


@Composable
fun RecipesComposable(navController: NavController) {
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
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = recipe.id,
                modifier = Modifier.size(50.dp).apply { padding(70.dp) }
            )
            Text(text = recipe.name, style = MaterialTheme.typography.h6)
            Text(text = recipe.id, style = MaterialTheme.typography.caption)

        }
    }
}

@Composable
fun ComicsComposable(navController: NavController) {
    val comics = remember { ComicsViewModel.DataProvider.comicsList }
    Column() {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.comic),
                contentDescription = "Comics",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "Comics",
                //modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = comics,
                itemContent = {
                    ComicListItem(comic = it)
                })
        }
    }
}

@Composable
fun ComicListItem(comic: Comics) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = comic.id.toString(),
                modifier = Modifier.size(50.dp).apply { padding(70.dp) }
            )
            Text(text = comic.comic_name, style = MaterialTheme.typography.h6)
            Text(text = comic.id.toString(), style = MaterialTheme.typography.caption)

        }
    }
}

@Composable
fun HealthPostComposable(navController: NavController) {
    val comics = remember { ComicsViewModel.DataProvider.comicsList }
    Column() {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.comic),
                contentDescription = "Comics",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "Comics",
                //modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = comics,
                itemContent = {
                    ComicListItem(comic = it)
                })
        }
    }
}
