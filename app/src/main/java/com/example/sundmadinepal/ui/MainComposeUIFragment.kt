package com.example.sundmadinepal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.sundmadinepal.R
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme

class MainComposeUIFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MainScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MainScreen() {
    val navIconSize: Int = 200
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()

    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.temp),
                contentDescription = "Temp",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "Home"
            )
        }
        Row(

        ) {
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "1000GoldenDays",
                    tint = Color.Magenta,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Recipes",
                    tint = Color.LightGray,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
        }
        Row() {
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Comics",
                    tint = Color.Yellow,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Quiz",
                    tint = Color.Green,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
        }
        Row() {
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "HealthPost",
                    tint = Color.Cyan,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Health",
                    tint = Color.Red,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
        }
    }
}


@Composable
fun MyScreen() {
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //Greeting("Android")
        MyScreen()
    }
}