package com.project.mapgames.ui.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.mapgames.R
import com.project.mapgames.model.dataGame.Task

class CompleteTaskFragment : Fragment(R.layout.complete_tasks_game_fragment) {
    private val gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<BottomNavigationView>(R.id.am_navigation)?.visibility = View.VISIBLE
    }
}