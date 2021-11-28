package com.example.sundmadinepal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.sundmadinepal.databinding.MainActivityBinding
import com.example.sundmadinepal.ui.MainComposeUIFragment
import androidx.navigation.NavController






class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<MainActivityBinding>(
            this,
            R.layout.main_activity
        )
        if (savedInstanceState == null) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController

            supportFragmentManager
                .beginTransaction()
                .add(binding.navHostFragment.id, MainComposeUIFragment())
                .commitNow()
        }


    }
}