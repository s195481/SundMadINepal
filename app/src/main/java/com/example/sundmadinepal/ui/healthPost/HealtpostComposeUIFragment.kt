package com.example.sundmadinepal.ui.healthPost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
import com.example.sundmadinepal.ui.health.HealthComposable
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme
import com.example.sundmadinepal.ui.utils.TopBarGenerator

class HealtpostComposeUIFragment : ComponentActivity() {
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
    }
    temp()
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

@Composable
fun temp(){
    CollapsableLazyColumn(
        sections = listOf(
            CollapsableSection(
                title = "Fruits A",
                rows = listOf("Apple", "Apricots", "Avocado")
            ),
            CollapsableSection(
                title = "Fruits B",
                rows = listOf("Banana", "Blackberries", "Blueberries")
            ),
            CollapsableSection(
                title = "Fruits C",
                rows = listOf("Cherimoya", "Cantaloupe", "Cherries", "Clementine")
            ),
        ),
    )
}

@Composable
fun CollapsableLazyColumn(
    sections: List<CollapsableSection>,
    modifier: Modifier = Modifier
) {
    val collapsedState = remember(sections) { sections.map { true }.toMutableStateList() }
    LazyColumn(modifier) {
        sections.forEachIndexed { i, dataItem ->
            val collapsed = collapsedState[i]
            item(key = "header_$i") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            collapsedState[i] = !collapsed
                        }
                ) {
                    Icon(
                        Icons.Default.run {
                            if (collapsed)
                                KeyboardArrowDown
                            else
                                KeyboardArrowUp
                        },
                        contentDescription = "",
                        tint = Color.LightGray,
                    )
                    Text(
                        dataItem.title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                }
                Divider()
            }
            if (!collapsed) {
                items(dataItem.rows) { row ->
                    Row {
                        Spacer(modifier = Modifier.size(MaterialIconDimension.dp))
                        Text(
                            row,
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                        )
                    }
                    Divider()
                }
            }
        }
    }
}
data class CollapsableSection(val title: String, val rows: List<String>)
const val MaterialIconDimension = 24f