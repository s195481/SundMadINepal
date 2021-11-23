package com.example.sundmadinepal.ui.health

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
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
fun TopBar(name: String){
    /*Column() {
        TextField(
            value = "Health",
            Modifier.padding(6.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.Red)
        )
    }*/
}


@Composable
fun MyScreen() {
    var textState1 by remember { mutableStateOf("") }
    var textState2 by remember { mutableStateOf("") }
    Column() {
        TextField(
            value = textState1,
            onValueChange = {
                Log.d("textState1:", "textState1: $it")
                textState1 = it
            },
            Modifier.padding(6.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.Red)
        )

        TextField(
            value = textState2,
            onValueChange = {
                Log.d("textState2:", "textState2: $it")
                textState2 = it
            },
            Modifier.padding(6.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.Blue)
        )

        Button(
            onClick = {
                Log.d("MyScreenButton", "MyScreenButton: $textState1, $textState2")
            },
            modifier = Modifier.scale(1.5f)
        ) {
            Text("Click me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //Greeting("Android")
        MyScreen()
    }
}