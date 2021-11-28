package com.example.sundmadinepal.ui.health

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
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

class HealthComposeUIFragment : Fragment() {
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
fun MainInfo() {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
            onClick = { }) {
            Icon(
                Icons.Filled.ArrowBack,
                "contentDescription",
                tint = Color.Red
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.temp),
            contentDescription = "Temp",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "Health"
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(24.dp)
            .background(Color.Yellow)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.temp),
            contentDescription = "Kid",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "name"
        )
        Text(
            text = "dd/mm/yyyy"
        )
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Height: "
            )
            Text(
                text = "55 cm"
            )
        }
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Weight: "
            )
            Text(
                text = "5 kg"
            )
        }
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Diary: "
            )
            Text(
                text = "Only eaten breastmilk so far."
            )
        }
    }
}


@Composable
fun MyScreen() {
    MainInfo()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //Greeting("Android")
        MyScreen()
    }
}