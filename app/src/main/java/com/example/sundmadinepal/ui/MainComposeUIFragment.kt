package com.example.sundmadinepal.ui

import android.content.Context
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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

class GoldenDaysComposeUIFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = "Hello world.")
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
            IconButton(modifier = Modifier.
            then(Modifier.size(24.dp)),
                onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "1000GoldenDays",
                    tint = Color.Magenta)
            }
            IconButton(modifier = Modifier.
            then(Modifier.size(24.dp)),
                onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "contentDescription",
                    tint = Color.LightGray)
            }
        }
        Row() {
            IconButton(modifier = Modifier.
            then(Modifier.size(24.dp)),
                onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "contentDescription",
                    tint = Color.Yellow)
            }
            IconButton(modifier = Modifier.
            then(Modifier.size(24.dp)),
                onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "contentDescription",
                    tint = Color.Green)
            }
        }
        Row() {
            IconButton(modifier = Modifier.
            then(Modifier.size(24.dp)),
                onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "contentDescription",
                    tint = Color.Cyan)
            }
            IconButton(modifier = Modifier.
            then(Modifier.size(24.dp)),
                onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "contentDescription",
                    tint = Color.Red)
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