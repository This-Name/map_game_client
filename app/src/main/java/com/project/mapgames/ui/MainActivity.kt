package com.project.mapgames.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.mapgames.R

class MainActivity : AppCompatActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = findNavController(R.id.as_nav_host).apply {}
        title = "Ramni"
        findViewById<BottomNavigationView>(R.id.am_navigation)
            .setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_task -> {
                        navController.navigate(R.id.action_global_main_game_fragment)
                        true
                    }
                    R.id.menu_map -> {
                        navController.navigate(R.id.action_global_map_game_fragment)
                        true
                    }
                    else -> false
                }
            }
    }
}