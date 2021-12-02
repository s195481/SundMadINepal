package com.example.sundmadinepal.ui.goldenDays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
import com.example.sundmadinepal.model.model.GoldenDays
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme
import com.example.sundmadinepal.ui.utils.TopBarGenerator

class GoldenDaysComposeUIFragment : ComponentActivity() {
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
        GoldenDaysComposable(navController)
        //GoldenDaysMaternityComposable(navController)
        //GoldenDaysFirstPeriodComposable(navController)
        //GoldenDaysSecondPeriodComposable(navController)
        //GoldenDaysThirdPeriodComposable(navController)
        //GoldenDaysFourthPeriodComposable(navController)
    }
}

@Composable
fun GoldenDaysComposable(navController: NavController) {
    val goldenDays = remember { GoldenDaysViewModel.DataProvider.goldenDaysList }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.Home_Col)),
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
    Row(
        modifier = Modifier.padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.navigate(goldenDays.goldenDayPeriod)
            },
            modifier = Modifier
                .apply { padding(imagePadding.dp) }
                .size(imageSize.dp)
                .clip(CircleShape)
                .border(1.5.dp, colorResource(id = R.color.Border_Col), CircleShape)
                .background(Color.White),
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
        Text(
            text = goldenDays.goldenDayPeriod,
            style = MaterialTheme.typography.h6,
        )
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
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}
