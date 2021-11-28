package com.example.sundmadinepal.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.sundmadinepal.R
import com.example.sundmadinepal.model.model.Comics
import com.example.sundmadinepal.ui.theme.SundMadINepalTheme

class ComicsComposeUIFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Comics()
            }
        }
    }
}


@Composable
fun Comics() {
    val comics = remember { ComicsViewModel.DataProvider.comicsList }
    Column() {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.comic),
                contentDescription = "Comics",
                modifier = Modifier.size(50.dp).apply { padding(50.dp) }
            )
            Text(
                text = "Comics",
                //modifier = Modifier.size(50.dp).apply { padding(50.dp) },
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = comics,
                itemContent = {
                    ComicListItem(comic = it)
                })
        }
    }
}

@Composable
fun ComicListItem(comic: Comics) {
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
                contentDescription = comic.id.toString(),
                modifier = Modifier.size(50.dp).apply { padding(70.dp) }
            )
            Text(text = comic.comic_name, style = MaterialTheme.typography.h6)
            Text(text = comic.id.toString(), style = MaterialTheme.typography.caption)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadINepalTheme {
        //Greeting("Android")
        Comics()
    }
}