package com.example.sundmadinepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                composable("recipes") { RecipesComposable(navController) }
                composable("goldenDays") { GoldenDaysComposable(navController) }
                composable("comics") { ComicsComposable(navController) }
                composable("health") { HealthComposable(navController) }
                composable("healthPost") { HealthPostComposable(navController) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        val navController = rememberNavController()
        //MainComposable(navController)
        //RecipesComposable(navController)
        //GoldenDaysComposable(navController)
        //ComicsComposable(navController)
        //HealthComposable(navController)
        HealthPostComposable(navController)
    }
}

@Composable
fun MainComposable(navController: NavController) {
    val navIconSize: Int = 150
    val navPadding: Int = navIconSize / 10
    val titleSize: Int = 100
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Home_Menu_Background)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.Figma_Home_top))

        ) {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = stringResource(R.string.home_string),
                modifier = Modifier.size(titleSize.dp).apply { padding(50.dp) }
            )
            Text(
                text = stringResource(R.string.home_string),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.size(titleSize.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Justify,
            )
        }
        Row() {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(navPadding.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))).background(colorResource(id = R.color.Golden_Days_Icon))
            ) {
                IconButton(modifier = Modifier
                    .then(Modifier.size(navIconSize.dp))
                        ,
                    onClick = {
                        navController.navigate("goldenDays")
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.newborn),
                        contentDescription = stringResource(R.string.title_goldenDays),
                        modifier = Modifier.size(navIconSize.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(navPadding.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))).background(colorResource(id = R.color.Recipe_Icon))
            ) {
                IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                    onClick = {
                        navController.navigate("recipes")
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.recipes),
                        contentDescription = stringResource(R.string.title_recipe),
                        modifier = Modifier.size(navIconSize.dp)
                    )
                }
            }
        }
        Row() {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(navPadding.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))).background(colorResource(id = R.color.Comics_Icon))
            ) {
                IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                    onClick = {
                        navController.navigate("comics")
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.comic),
                        contentDescription = stringResource(R.string.title_comics),
                        modifier = Modifier.size(navIconSize.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(navPadding.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))).background(colorResource(id = R.color.Quiz_Icon))
            ) {
                IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                    onClick = {

                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.quiz),
                        contentDescription = stringResource(R.string.title_quiz),
                        modifier = Modifier.size(navIconSize.dp)
                    )
                }
            }
        }
        Row() {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(navPadding.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))).background(colorResource(id = R.color.Healthpost_Icon))
            ) {
                IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                    onClick = {
                        navController.navigate("healthPost")
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.health_post),
                        contentDescription = stringResource(R.string.title_healthpost),
                        modifier = Modifier.size(navIconSize.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(navPadding.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))).background(colorResource(id = R.color.Health_Icon))
            ) {
                IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                    onClick = {
                        navController.navigate("health")
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baby),
                        modifier = Modifier.size(navIconSize.dp)
                        contentDescription = stringResource(R.string.title_health),
                    )
                }
            }
        }
    }
}


@Composable
fun GoldenDaysComposable(navController: NavController) {
    val goldenDays = remember { GoldenDaysViewModel.DataProvider.goldenDaysList }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.newborn,
            title = stringResource(R.string.title_goldenDays),
            titleSize = 100
        )

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

//TODO Fix it's ugly as fuuuck
@Composable
fun HealthComposable(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.baby,
            title = stringResource(R.string.title_health),
            titleSize = 100
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(24.dp)
                .background(Color.Yellow)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.temp),
                contentDescription = stringResource(R.string.child_string),
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = stringResource(R.string.name_string)
            )
            Text(
                text = (stringResource(R.string.day_string) + "/" + stringResource(R.string.months_string) + "/" + stringResource(R.string.year_string))
            )
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = (stringResource(R.string.height_string) + ":")
                )
                Text(
                    text = "55 cm"
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = (stringResource(R.string.weight_string) + ":")
                )
                Text(
                    text = "5 kg"
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = (stringResource(R.string.diary_string) + ":")
                )
                Text(
                    text = "Only eaten breastmilk so far."
                )
            }
        }
    }
}


@Composable
fun RecipesComposable(navController: NavController) {
    val recipes = remember { RecipeViewModel.DataProvider.recipeList }
    Column(
        Modifier.fillMaxWidth()
    ) {
        TopBarGenerator(navController, R.drawable.recipes, stringResource(R.string.title_recipe), 100)
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
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.comic,
            title = stringResource(R.string.title_comics),
            titleSize = 100
        )
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
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.health_post,
            title = stringResource(R.string.title_healthpost),
            titleSize = 100
        )
    }
}

@Composable
fun TopBarGenerator(
    navController: NavController,
    titleImageSrc: Int,
    title: String,
    titleSize: Int
) {
    val titlePadding: Int = titleSize / 10
    val backButtonSize: Int = titleSize / 2
    Row(
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(titleSize.dp)
                .padding(titlePadding.dp)
        ) {
            IconButton(modifier = Modifier.then(Modifier.size(backButtonSize.dp)),
                onClick = {
                    navController.navigate("main")
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.backbutton),
                    "backbutton",
                    modifier = Modifier.size(backButtonSize.dp)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = titleImageSrc),
                contentDescription = title,
                modifier = Modifier
                    .size(titleSize.dp)
                    .padding(titlePadding.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(titlePadding.dp),
                textAlign = TextAlign.Justify,
            )
        }
    }
}
