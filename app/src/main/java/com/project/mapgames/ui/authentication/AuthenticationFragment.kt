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

class AuthenticationFragment : Fragment(R.layout.authentication_fragment) {
    private val authenticationViewModel by viewModels<AuthenticationViewModel>()
    private var bundle = Bundle()
    private var codeGame = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<BottomNavigationView>(R.id.am_navigation)?.visibility = View.GONE
        view.findViewById<Button>(R.id.send_code_button).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                try {
                    codeGame = view.findViewById<EditText>(R.id.code_games_input).text.toString()
                    val her = authenticationViewModel.checkGame(
                        codeGame
                    )
                    bundle.putString(
                        "codeGame",
                        codeGame
                    )

                    findNavController().navigate(
                        R.id.action_authentication_fragment_to_username_fragment,
                        bundle
                    )
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
