package com.example.sundmadinepal.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
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

/*
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
}*/
@Composable
fun MyScreen(viewModel: ComicsViewModel) {
}


@Composable
fun MyTextField(state: String, onValueChange: (String) -> Unit) {
    TextField(
        state,
        onValueChange,
        maxLines = 2,
        shape = RoundedCornerShape(4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //Greeting("Android")
        //MyTextField()
    }
}