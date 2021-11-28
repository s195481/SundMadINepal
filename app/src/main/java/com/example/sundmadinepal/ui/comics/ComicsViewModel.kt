package com.example.sundmadinepal.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}