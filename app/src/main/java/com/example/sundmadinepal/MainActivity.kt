package com.example.sundmadinepal

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.sundmadinepal.databinding.MainActivityBinding
import com.example.sundmadinepal.ui.MainComposeUIFragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import java.sql.Types.NULL


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