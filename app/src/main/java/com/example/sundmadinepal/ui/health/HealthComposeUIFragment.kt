package com.example.sundmadinepal.ui.health

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme
import com.example.sundmadinepal.ui.utils.TopBarGenerator

class HealthComposeUIFragment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: HealthViewModel
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

@Composable
fun HealthComposable(navController: NavController) {
    var name by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.Home_Col)),
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .size(150.dp)
                    .padding(20.dp),
            ) {
                IconButton(
                    modifier = Modifier
                        .then(Modifier.size(150.dp))
                        .clip(CircleShape)
                        .border(1.5.dp, colorResource(id = R.color.Border_Col), CircleShape)
                        .background(Color.White),
                    onClick = {
                        //TODO Add ability to change picture
                        //Toast.makeText(LocalContext.current,"Picture changing not implemented",Toast.LENGTH_LONG).show()
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.defaultbabyprofile),
                        contentDescription = stringResource(R.string.child_string),
                        modifier = Modifier
                            .size(150.dp)
                    )
                }
            }
            Row(

            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(stringResource(R.string.name_string)) }
                )
            }

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(
                        stringResource(R.string.day_string) + "/" +
                                stringResource(R.string.months_string) + "/" +
                                stringResource(R.string.year_string)
                    )
                }
            )
        }
        Column() {
            InfoBarGenerator(
                infoType = (stringResource(R.string.height_string) + ":")
            )
            InfoBarGenerator(
                infoType = (stringResource(R.string.weight_string) + ":")
            )
            InfoBarGenerator(
                infoType = (stringResource(R.string.diary_string) + ":")
            )
        }
    }
}

@Composable
fun InfoBarGenerator(infoType: String) {
    var infoFill by remember { mutableStateOf("") }

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
                .background(colorResource(id = R.color.Bar_Col))
        ) {
            Text(
                text = infoType,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )

            TextField(
                value = infoFill,
                onValueChange = { infoFill = it },
                label = { Text("") },
            )

        }
    }
}


