package com.example.sundmadinepal.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sundmadinepal.R

class Tools

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



@Composable
fun NotImplemented(
    navController: NavController
) {
    val title: String = "Not Implemented"
    val titleSize: Int = 100
    val titlePadding: Int = titleSize / 10
    val backButtonSize: Int = titleSize / 2
    Row(
        modifier = Modifier
            .background(Color.Gray)
    ) {
        if (false) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(titleSize.dp)
                    .padding(titlePadding.dp),
            ) {
                IconButton(modifier = Modifier.then(Modifier.size(backButtonSize.dp)),
                    onClick = {
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
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(titlePadding.dp),
                textAlign = TextAlign.Justify,
            )
        }
    }
}