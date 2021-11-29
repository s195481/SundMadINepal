package com.example.sundmadinepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadinepal.ui.MainComposeUIFragment
import com.example.sundmadinepal.ui.comics.ComicsComposeUIFragment
import com.example.sundmadinepal.ui.goldenDays.GoldenDaysComposeUIFragment
import com.example.sundmadinepal.ui.health.HealthComposeUIFragment
import com.example.sundmadinepal.ui.recipe.RecipeComposeUIFragment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComposeUIFragment()
        }
    }
}