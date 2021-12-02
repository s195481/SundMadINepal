package com.example.sundmadinepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.ui.comics.ComicsComposable
import com.example.sundmadinepal.ui.goldenDays.*
import com.example.sundmadinepal.ui.health.HealthComposable
import com.example.sundmadinepal.ui.healthPost.HealthPostComposable
import com.example.sundmadinepal.ui.recipe.RecipeDetailedComposable
import com.example.sundmadinepal.ui.recipe.RecipesComposable
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme
import com.example.sundmadinepal.ui.utils.TopBarGenerator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // To call or not call
        //App()
        // That is the question
        //init(App())
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { MainComposable(navController) }
                composable("recipes") { RecipesComposable(navController) }
                // TODO Edit guy below when things start working
                composable("recipeDetailed") { RecipeDetailedComposable(navController) }
                composable("goldenDays") { GoldenDaysComposable(navController) }
                composable("Maternity") { GoldenDaysMaternityComposable(navController) }
                composable("0-6 Months") { GoldenDaysFirstPeriodComposable(navController) }
                composable("6-9 Months") { GoldenDaysSecondPeriodComposable(navController) }
                composable("9-12 Months") { GoldenDaysThirdPeriodComposable(navController) }
                composable("12-24 Months") { GoldenDaysFourthPeriodComposable(navController) }
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
        //GoldenDaysMaternityComposable(navController)
        //GoldenDaysFirstPeriodComposable(navController)
        //GoldenDaysSecondPeriodComposable(navController)
        //GoldenDaysThirdPeriodComposable(navController)
        //GoldenDaysFourthPeriodComposable(navController)

        //ComicsComposable(navController)
        //HealthComposable(navController)
        //HealthPostComposable(navController)

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
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.home,
            title = stringResource(id = R.string.home_string),
            titleSize = titleSize,
            backButtonBool = false,
            color = R.color.Figma_Home_top
        )
        Row() {
            NavFromHomeGenerator(
                navController = navController,
                destination = "goldenDays",
                title = R.string.title_goldenDays,
                imageSrc = R.drawable.newborn,
                iconSize = navIconSize,
                color = R.color.Golden_Days_Icon,
                padding = navPadding
            )
            NavFromHomeGenerator(
                navController = navController,
                destination = "recipes",
                title = R.string.title_recipe,
                imageSrc = R.drawable.recipes,
                iconSize = navIconSize,
                color = R.color.Recipe_Icon,
                padding = navPadding
            )
        }
        Row() {
            NavFromHomeGenerator(
                navController = navController,
                destination = "comics",
                title = R.string.title_comics,
                imageSrc = R.drawable.comic,
                iconSize = navIconSize,
                color = R.color.Comics_Icon,
                padding = navPadding
            )
            NavFromHomeGenerator(
                navController = navController,
                destination = "",
                title = R.string.title_quiz,
                imageSrc = R.drawable.quiz,
                iconSize = navIconSize,
                color = R.color.Quiz_Icon,
                padding = navPadding
            )
        }
        Row() {
            NavFromHomeGenerator(
                navController = navController,
                destination = "healthPost",
                title = R.string.title_healthpost,
                imageSrc = R.drawable.health_post,
                iconSize = navIconSize,
                color = R.color.Healthpost_Icon,
                padding = navPadding
            )
            NavFromHomeGenerator(
                navController = navController,
                destination = "health",
                title = R.string.title_health,
                imageSrc = R.drawable.baby,
                iconSize = navIconSize,
                color = R.color.Health_Icon,
                padding = navPadding
            )
        }
    }
}

@Composable
fun NavFromHomeGenerator(
    navController: NavController,
    destination: String,
    title: Int,
    imageSrc: Int,
    iconSize: Int,
    color: Int,
    padding: Int
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(padding.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .background(colorResource(id = color))
    ) {
        IconButton(modifier = Modifier.then(Modifier.size(iconSize.dp)),
            onClick = {
                navController.navigate(destination)
            }) {
            Icon(
                painter = painterResource(id = imageSrc),
                contentDescription = stringResource(title),
                modifier = Modifier.size(iconSize.dp)
            )
        }
    }
}

