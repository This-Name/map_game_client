package com.project.mapgames.model.dataGame

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifyGame(
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("short_name")
    val short_name: String
)