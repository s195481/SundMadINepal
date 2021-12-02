package com.example.sundmadinepal.ui.healthPost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
import com.example.sundmadinepal.ui.health.HealthComposable
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme
import com.example.sundmadinepal.ui.utils.TopBarGenerator

class HealtPostComposeUIFragment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        val navController = rememberNavController()
        HealthPostComposable(navController)
    }
}

@ExperimentalAnimationApi
@Composable
fun HealthPostComposable(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(colorResource(R.color.Home_Col))
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.health_post,
            title = stringResource(R.string.title_healthpost),
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Healthpost_Icon
        )
        Expandable()
    }
}


@Composable
fun NavFromHealthpostGenerator(
    navController: NavController,
    destination: String,
    title: Int,
    imageSrc: Int,
    iconSize: Int,
    color: Int,
    padding: Int
) {
    val modifiedIconSize: Double = (iconSize*0.8)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(padding.dp)
            .background(colorResource(id = color), RoundedCornerShape(corner = CornerSize(16.dp)))
            .border(5.dp, colorResource(id = R.color.Border_Col))
    ) {
        Text(
            text = stringResource(title),
            modifier = Modifier.padding(4.dp)
        )
        IconButton(
            modifier = Modifier
                .size(iconSize.dp),
            onClick = {
                navController.navigate(destination)
            }) {
            Icon(
                painter = painterResource(id = imageSrc),
                contentDescription = stringResource(title),
                modifier = Modifier
                    .size(modifiedIconSize.dp)
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun Expandable() {
    var isExpanded: Boolean = false
    Card(
        modifier = Modifier.clickable {
            isExpanded = !isExpanded
        }
    ) {
        Column() {

            Text(text = "This text is always shown",
                modifier = Modifier.padding(4.dp))

            AnimatedVisibility(visible = isExpanded) {
                Row() {
                    TextField(label = { Text("Amount")} ,value = "", onValueChange = {})
                    Button(onClick = {
                        isExpanded = !isExpanded
                    }) {
                    }
                }
            }
        }
    }

}