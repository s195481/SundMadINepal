package com.example.sundmadinepal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
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
    Column() {
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
        Row() {
            IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "1000GoldenDays",
                    tint = Color.Magenta
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Recipes",
                    tint = Color.LightGray
                )
            }
        }
        Row() {
            IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Comics",
                    tint = Color.Yellow
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Quiz",
                    tint = Color.Green
                )
            }
        }
        Row() {
            IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "HealthPost",
                    tint = Color.Cyan
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
                onClick = {

                }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Health",
                    tint = Color.Red
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