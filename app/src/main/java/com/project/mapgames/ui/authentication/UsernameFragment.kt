package com.project.mapgames.ui.authentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.mapgames.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class UsernameFragment : Fragment(R.layout.username_fragment) {
    private val usernameViewModel by viewModels<UsernameViewModel>()
    private var bundle = Bundle()
    private lateinit var codeGame: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        codeGame = checkNotNull(arguments?.getString("codeGame"))
        activity?.findViewById<BottomNavigationView>(R.id.am_navigation)?.visibility = View.GONE
        view.findViewById<Button>(R.id.send_username_button).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val userName = view.findViewById<EditText>(R.id.username_input).text.toString()
                val kek = usernameViewModel.startGame(
                    codeGame,
                    userName
                )
                bundle.putParcelableArrayList("tasks", kek.tasks)
                val data =
                    ArrayList<String>() // можно помещать любые данные которые нужны дальше
                data.add(codeGame)
                data.add(userName)
                bundle.putStringArrayList(
                    "CodeGameAndUserName",
                    data
                )
                findNavController().navigate(R.id.action_username_fragment_to_game_fragment, bundle)
            }
        }
    }
}
