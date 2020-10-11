package com.project.mapgames.model.dataGame

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataGame(
    @SerialName("game")
    val game: Game,
    @SerialName("now_on")
    val now_on: Int?,
    @SerialName("tasks")
    val tasks: ArrayList<Task>
)