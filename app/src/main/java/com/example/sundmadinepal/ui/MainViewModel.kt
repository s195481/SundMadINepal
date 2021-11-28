package com.example.sundmadinepal.ui

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.sundmadinepal.MainActivity
import com.example.sundmadinepal.R

class MainViewModel() : ViewModel() {
    private val navController = Navigation.findNavController(MainActivity(),R.id.nav_host_fragment)

    fun navigateToGoldendays(){
        navController.navigate(R.id.action_mainComposeUIFragment_to_recipeFragment)
    }

}