package com.example.sundmadinepal.ui.comics

import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.model.model.Comics

class ComicsViewModel : ViewModel() {

    object DataProvider {
        val comicsList = listOf(
            Comics(
                comic_name = "Comic 1",
                //comic_pictures = TODO(),
                id = 1
            ),
            Comics(
                comic_name = "Comic 2",
                //comic_pictures = TODO(),
                id = 2
            ),
            Comics(
                comic_name = "Comic 3",
                //comic_pictures = TODO(),
                id = 3
            ),

            )
    }
}