package com.project.mapgames.ui.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.mapgames.model.Repository

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {
    suspend fun checkGame(codeGame: String) = Repository().checkGame(codeGame)
}
