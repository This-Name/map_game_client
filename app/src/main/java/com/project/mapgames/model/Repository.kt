package com.project.mapgames.model

import com.project.mapgames.MainApplication
import com.project.mapgames.model.dataGame.VerifyGame
import java.lang.Exception

class Repository {
    private val gameApi = MainApplication.apiDV

    //abcde
    suspend fun checkGame(codeGame: String) =
        gameApi.checkGame(codeGame) ?: throw Exception("ErrorCodeGame")

    suspend fun startGame(codeGame: String, userName: String) =
        gameApi.startGame(codeGame, userName)

    suspend fun completeTask(codeGame: String, userName: String) {
        gameApi.completeTask(codeGame, userName)
    }
}