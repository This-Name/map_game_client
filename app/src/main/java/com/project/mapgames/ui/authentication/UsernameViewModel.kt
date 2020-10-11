package com.project.mapgames.ui.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.mapgames.model.Repository

class UsernameViewModel(application: Application) : AndroidViewModel(application) {
    suspend fun startGame(codeGame: String, userName: String) = Repository().startGame(codeGame, userName)
}
