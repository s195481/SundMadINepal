package com.example.sundmadinepal.ui.health

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
import com.example.sundmadinepal.ui.utils.TopBarGenerator
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme

class HealthComposeUIFragment : ComponentActivity() {
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
        HealthComposable(navController)
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


