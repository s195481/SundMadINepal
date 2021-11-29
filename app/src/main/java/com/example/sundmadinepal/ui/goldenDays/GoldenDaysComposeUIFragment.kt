package com.example.sundmadinepal.ui.goldenDays

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.R
import com.example.sundmadinepal.model.model.Comics
import com.example.sundmadinepal.model.model.GoldenDays
import com.example.sundmadinepal.ui.comics.ComicsViewModel
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme

class GoldenDaysComposeUIFragment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            GoldenDays(navController)
        }
    }
}

@Composable
fun GoldenDays(navController: NavController) {
    val goldenDays = remember { GoldenDaysViewModel.DataProvider.goldenDaysList }
    Column() {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.newborn),
                contentDescription = "GoldenDays",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "1000 Golden Days",
                //modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = goldenDays,
                itemContent = {
                    GoldenDaysListItem(goldenDays = it)
                })
        }
    }
}

@Composable
fun GoldenDaysListItem(goldenDays: GoldenDays) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
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
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = goldenDays.goldenDayPeriod,
                modifier = Modifier.size(50.dp).apply { padding(70.dp) }
            )
            Text(text = goldenDays.goldenDayPeriod, style = MaterialTheme.typography.h6)
            Text(text = goldenDays.goldenDayTex, style = MaterialTheme.typography.caption)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //Greeting("Android")
        val navController = rememberNavController()
        GoldenDays(navController)
    }
}

// TODO Smarte ting nedenunder ift. at lave stateflow og databinding og sådan. Vent med at slette det.
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
}
@Composable
fun MyScreen(viewModel: GoldenDaysViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Modifier.fillMaxSize()
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            itemsIndexed(items = viewModel.listOfCurrencies) { index, item ->
                Text(text = "$item $index")
            }
        }
        val cryptos by viewModel.listOfCryptos.collectAsState()
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            itemsIndexed(items = cryptos) { index, item ->
                Text(text = "$item $index")
            }
        }

        Column() {
            Button(onClick = {
                viewModel.addCurrency("Cur ")
                Log.d("WAH", "WAH")
            }) {
                Text(text = "Add currency")
            }
            Button(onClick = {
                viewModel.addCrypto("Crypto ")
            }) {
                Text(text = "Add crypto")
            }
        }
    }
}


@Composable
fun MyTextField(state: Comics, onValueChange: (String) -> Unit) {
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
        var viewModel = GoldenDaysViewModel();
        MyScreen(viewModel)
        //MyTextField()
    }
}
 */