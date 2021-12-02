package com.example.sundmadinepal.ui.healthPost

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        val navController = rememberNavController()
        HealthPostComposable(navController)
    }
}

@Composable
fun HealthPostComposable(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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
        temp()
    }
}


@Composable
fun temp() {
    CollapsableLazyColumn(
        sections = listOf(
            CollapsableSection(
                title = stringResource(id = R.string.healthpost_baby_pregnancy_title),
                rows = listOf(stringResource(id = R.string.healthpost_baby_pregnancy)),
                images = listOf(
                    R.drawable.balanceddiet_nomeat/*, R.drawable.handwashing,
                    R.drawable.visithealthpost, R.drawable.whentowashhands*/
                )
            ),
            CollapsableSection(
                title = stringResource(id = R.string.healthpost_baby_zerotosix_title),
                rows = listOf(stringResource(id = R.string.healthpost_baby_zerotosix)),
                images = listOf(R.drawable.woman_breastfeeding/*, R.drawable.handwashing*/)
            ),
            CollapsableSection(
                title = stringResource(id = R.string.healthpost_baby_sixtonine_title),
                rows = listOf(stringResource(id = R.string.healthpost_baby_sixtonine)),
                images = listOf(/*
                    R.drawable.woman_breastfeeding, R.drawable.nutritionalflour,
                    R.drawable.nutritionalflour, */R.drawable.p0/*, R.drawable.handwashing*/
                )
            ),
            CollapsableSection(
                title = stringResource(id = R.string.healthpost_baby_ninetotwelve_title),
                rows = listOf(stringResource(id = R.string.healthpost_baby_ninetotwelve)),
                images = listOf(/*
                    R.drawable.woman_breastfeeding, R.drawable.nutritionalflour,
                    R.drawable.nutritionalflour, R.drawable.banana,*/ R.drawable.spinach/*,
                    R.drawable.jaulo, R.drawable.handwashing*/
                )
            ),
            CollapsableSection(
                title = stringResource(id = R.string.healthpost_fourfoodgroups_title),
                rows = listOf(stringResource(id = R.string.healthpost_fourfoodgroups)),
                images = listOf(R.drawable.vegetables)
            ),
        ),
    )
}

/*
Credits to https://stackoverflow.com/questions/68992694/how-to-create-expandable-list-view-with-static-values-in-jetpack-compose
for inspiration to the collapsable lazy column. It has received small edits but the credit should non the less go to stackoverflow user Philip Dukhov
 */
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
                        tint = colorResource(R.color.black),
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
                items(dataItem.images) { image ->
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.White, RoundedCornerShape(corner = CornerSize(40.dp)))
                    ){
                    Image(
                        painter = painterResource(image),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),

                    )
                    }
                }

            }
        }
    }
}

data class CollapsableSection(val title: String, val rows: List<String>, val images: List<Int>)

const val MaterialIconDimension = 24f