package com.project.mapgames.model.api

import com.project.mapgames.model.dataGame.DataGame
import com.project.mapgames.model.dataGame.VerifyGame
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

@Suppress("ComplexInterface")
interface DVapi {
    @GET("api/game/{gameCode}")
    suspend fun checkGame(
        @Path("gameCode") codeGame: String
    ): VerifyGame

    @GET("api/game/{gameCode}/info/{playerName}")
    suspend fun startGame(
        @Path("gameCode") codeGame: String,
        @Path("playerName") userName: String
    ): DataGame

    @POST("api/game/{gameSN}/player/{playerName}/task/complete")
    suspend fun completeTask(
        @Path("gameSN") codeGame: String,
        @Path("playerName") userName: String
    )
}
