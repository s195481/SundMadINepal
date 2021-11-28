package com.example.sundmadinepal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.sundmadinepal.MainActivity

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
fun MainScreen() {
    val navIconSize: Int = 170
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "Home",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        Row(

        ) {
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {
                    Navigation.findNavController(MainActivity(),R.id.nav_host_fragment).navigate(R.id.action_mainComposeUIFragment_to_goldenDaysComposeUIFragment)
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.newborn),
                    "1000GoldenDays",
                    tint = Color.Magenta,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {


                }) {
                Icon(
                    painter = painterResource(id = R.drawable.recipes),
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
                    painter = painterResource(id = R.drawable.comic),
                    "Comics",
                    tint = Color.Yellow,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    painter = painterResource(id = R.drawable.quiz),
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
                    painter = painterResource(id = R.drawable.health_post),
                    "HealthPost",
                    tint = Color.Cyan,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
            IconButton(modifier = Modifier.then(Modifier.size(navIconSize.dp)),
                onClick = {

                }) {
                Icon(
                    painter = painterResource(id = R.drawable.baby),
                    "Health",
                    tint = Color.Red,
                    modifier = Modifier.size(navIconSize.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        MainScreen()
    }
}