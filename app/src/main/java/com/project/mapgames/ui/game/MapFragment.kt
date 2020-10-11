package com.project.mapgames.ui.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.mapgames.R
import com.project.mapgames.model.dataGame.Task

class MapFragment : Fragment(R.layout.map_game_fragment) {
    //private val gameViewModel by viewModels<GameViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<BottomNavigationView>(R.id.am_navigation)?.visibility = View.INVISIBLE
    }
}