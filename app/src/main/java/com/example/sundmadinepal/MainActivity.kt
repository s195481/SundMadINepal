package com.example.sundmadinepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
        // To call or not call
        //App()
        // That is the question
        //init(App())
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { MainComposable(navController) }
                composable("recipes") { RecipesComposable(navController) }
                // TODO composable("recipeDetails") { RecipesDetailedComposable(navController) }
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
        GoldenDaysComposable(navController)
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
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Golden_Days_Icon
        )

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        ) {
            items(
                items = goldenDays,
                itemContent = {
                    GoldenDaysListItem(navController, goldenDays = it)
                })
        }
    }
}


@Composable
fun GoldenDaysListItem(navController: NavController, goldenDays: GoldenDays) {
    val imageSize: Int = 220
    val imagePadding: Int = 0
    Row(modifier = Modifier.padding(all = 8.dp),
    verticalAlignment = Alignment.CenterVertically) {
        IconButton(
            onClick = {
                navController.navigate(goldenDays.goldenDayPeriod)
            },
            modifier = Modifier
                .apply { padding(imagePadding.dp) }
                .size(imageSize.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Black, CircleShape)
        ) {
            if (goldenDays.goldenDayPicture == "maternity") {
                Image(
                    painter = painterResource(R.drawable.maternity),
                    contentDescription = goldenDays.goldenDayPeriod
                )
            } else if (goldenDays.goldenDayPicture == "zerotosixmonths") {
                Image(
                    painter = painterResource(R.drawable.zerotosixsmonth),
                    contentDescription = goldenDays.goldenDayPeriod
                )
            } else if (goldenDays.goldenDayPicture == "sixtoninemonths") {
                Image(
                    painter = painterResource(R.drawable.sixtoninemonths),
                    contentDescription = goldenDays.goldenDayPeriod
                )
            } else if (goldenDays.goldenDayPicture == "ninetotwelvemonths") {
                Image(
                    painter = painterResource(R.drawable.ninetotwelvemonths),
                    contentDescription = goldenDays.goldenDayPeriod
                )
            } else if (goldenDays.goldenDayPicture == "twelvetotwentyfourmonths") {
                Image(
                    painter = painterResource(R.drawable.twelvetotwentyfourmonths),
                    contentDescription = goldenDays.goldenDayPeriod
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.information),
                    contentDescription = goldenDays.goldenDayPeriod
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = goldenDays.goldenDayPeriod,
            style = MaterialTheme.typography.h6)
    }
}

@Composable
fun GoldenDaysMaternityComposable(navController: NavController) {
    GoldenDaysPeriodGenerator(
        navController = navController,
        title = R.string.maternity_string,
        picture = R.drawable.maternity,
        breadText = R.string.maternity_detailed_string
    )
}

@Composable
fun GoldenDaysFirstPeriodComposable(navController: NavController) {
    GoldenDaysPeriodGenerator(
        navController = navController,
        title = R.string.zeroToSixMonths_string,
        picture = R.drawable.zerotosixsmonth,
        breadText = R.string.zeroToSixMonths_detailed_string
    )
}

@Composable
fun GoldenDaysSecondPeriodComposable(navController: NavController) {
    GoldenDaysPeriodGenerator(
        navController = navController,
        title = R.string.sixToNineMonths_string,
        picture = R.drawable.sixtoninemonths,
        breadText = R.string.sixToNineMonths_detailed_string
    )
}

@Composable
fun GoldenDaysThirdPeriodComposable(navController: NavController) {
    GoldenDaysPeriodGenerator(
        navController = navController,
        title = R.string.nineToTwelveMonths_string,
        picture = R.drawable.ninetotwelvemonths,
        breadText = R.string.nineToTwelveMonths_detailed_string
    )
}

@Composable
fun GoldenDaysFourthPeriodComposable(navController: NavController) {
    GoldenDaysPeriodGenerator(
        navController = navController,
        title = R.string.twelveToTwentyfourMonths_string,
        picture = R.drawable.twelvetotwentyfourmonths,
        breadText = R.string.twelveToTwentyFourMonths_detailed_string
    )
}


@Composable
fun GoldenDaysPeriodGenerator(
    navController: NavController,
    title: Int,
    picture: Int,
    breadText: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.newborn,
            title = stringResource(title),
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Golden_Days_Icon
        )
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}

//TODO Fix it's ugly as fuuuck
@Composable
fun HealthComposable(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.baby,
            title = stringResource(R.string.title_health),
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Health_Icon
        )
        Column(
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .clip(RoundedCornerShape(corner = CornerSize(40.dp))),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(corner = CornerSize(40.dp)))
                    .padding(20.dp),
            ) {
                IconButton(
                    modifier = Modifier
                        .then(Modifier.size(150.dp))
                        .clip(
                            RoundedCornerShape(corner = CornerSize(40.dp))
                        ),
                    onClick = {
                        //TODO Add ability to change picture
                        //Toast.makeText(LocalContext.current,"Picture changing not implemented",Toast.LENGTH_LONG).show()
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.defaultbabyprofile),
                        contentDescription = stringResource(R.string.child_string),
                        modifier = Modifier
                            .size(150.dp)
                            .background(Color.White),
                    )
                }
            }
            Text(
                text = stringResource(R.string.name_string),
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = (stringResource(R.string.day_string) + "/" +
                        stringResource(R.string.months_string) + "/" +
                        stringResource(R.string.year_string)),
                modifier = Modifier.padding(5.dp)
            )
        }
        Column() {
            InfoBarGenerator(
                infoType = (stringResource(R.string.height_string) + ":"),
                infoFill = "55cm"
            )
            InfoBarGenerator(
                infoType = (stringResource(R.string.weight_string) + ":"),
                infoFill = "5kg"
            )
            InfoBarGenerator(
                infoType = (stringResource(R.string.diary_string) + ":"),
                infoFill = "He's a sucker for breastmilk"
            )
        }
    }
}

@Composable
fun InfoBarGenerator(infoType: String, infoFill: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
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
            Text(
                text = infoType,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = infoFill,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}


@Composable
fun RecipesComposable(navController: NavController) {
    //val recipes2 = remember { RecipeViewModel().getRecipes()}
    val recipes = remember { RecipeViewModel.DataProvider.recipeList }
    Column(
        Modifier.fillMaxWidth()
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
                    RecipeListItem(recipe = it as Recipe)
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
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Comics_Icon
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
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Healthpost_Icon
        )
    }
}

@Composable
fun TopBarGenerator(
    navController: NavController,
    titleImageSrc: Int,
    title: String,
    titleSize: Int,
    backButtonBool: Boolean,
    color: Int
) {
    val titlePadding: Int = titleSize / 10
    val backButtonSize: Int = titleSize / 2
    Row(
        modifier = Modifier
            .background(colorResource(color))
    ) {
        if (backButtonBool) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(titleSize.dp)
                    .padding(titlePadding.dp),
            ) {
                IconButton(modifier = Modifier.then(Modifier.size(backButtonSize.dp)),
                    onClick = {
                        //navController.navigate("main")
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
                painter = painterResource(id = titleImageSrc),
                contentDescription = title,
                modifier = Modifier
                    .size(titleSize.dp)
                    .padding(titlePadding.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(titlePadding.dp),
                textAlign = TextAlign.Justify,
            )
        }
    }
}
