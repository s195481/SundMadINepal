package com.example.sundmadinepal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sundmadinepal.databinding.MainActivityBinding
import com.example.sundmadinepal.ui.MainComposeUIFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(
            this,
            R.layout.main_activity
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(binding.container.id, MainComposeUIFragment())
                .commitNow()
        }
    }
}