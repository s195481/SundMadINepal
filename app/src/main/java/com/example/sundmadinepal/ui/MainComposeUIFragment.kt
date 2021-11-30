package com.example.sundmadinepal.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
import com.example.sundmadinepal.ui.comics.ComicsComposeUIFragment
import com.example.sundmadinepal.ui.goldenDays.GoldenDaysComposeUIFragment
import com.example.sundmadinepal.ui.health.HealthComposeUIFragment
import com.example.sundmadinepal.ui.recipe.RecipeComposeUIFragment
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme

class MainComposeUIFragment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "MainComposeUIFragment") {
                composable("MainComposeUIFragment") { MainComposeUIFragment() }
                composable("RecipeComposeUIFragment") { RecipeComposeUIFragment() }
                composable("GoldenDaysComposeUIFragment") { GoldenDaysComposeUIFragment() }
                composable("ComicsComposeUIFragment") { ComicsComposeUIFragment() }
                composable("HealthComposeUIFragment") { HealthComposeUIFragment() }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
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
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {
                    navController.navigate("GoldenDaysComposeUIFragment")
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
                    "Quiz",
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
                    "HealthPost",
                    tint = Color.Cyan,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //MainScreen()
    }
}