package com.example.sundmadinepal.ui.comics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
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

class ComicsComposeUIFragment : ComponentActivity() {
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
        ComicsComposable(navController)
    }
}

@Composable
fun ComicsComposable(navController: NavController) {
    val comics = remember { ComicsViewModel.DataProvider.comicsList }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.Home_Col)),
    ) {
        TopBarGenerator(
            navController = navController,
            titleImageSrc = R.drawable.comic,
            title = stringResource(R.string.title_comics),
            titleSize = 100,
            backButtonBool = true,
            color = R.color.Comics_Icon
        )
        ComicItemsComposable()
    }
}


@Composable
fun ComicItemsComposable() {
    CollapsableLazyColumn(
        sections = listOf(
            CollapsableSection(
                title = stringResource(id = R.string.a_comic),
                images = listOf(
                    R.drawable.a_comic_a,
                    R.drawable.a_comic_b,
                    R.drawable.a_comic_c,
                    R.drawable.a_comic_d,
                    R.drawable.a_comic_e,
                    R.drawable.a_comic_f
                )
            ),
            CollapsableSection(
                title = stringResource(id = R.string.b_comic),
                images = listOf(
                    R.drawable.b_comic_a,
                    R.drawable.b_comic_b,
                    R.drawable.b_comic_c,
                    R.drawable.b_comic_d,
                    R.drawable.b_comic_e,
                    R.drawable.b_comic_f
                )
            ),
        )
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
                        tint = colorResource(R.color.Bar_Col),
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
                items(dataItem.images) { image ->
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.White, RoundedCornerShape(corner = CornerSize(40.dp)))
                    ) {
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

data class CollapsableSection(val title: String, val images: List<Int>)

const val MaterialIconDimension = 24f
