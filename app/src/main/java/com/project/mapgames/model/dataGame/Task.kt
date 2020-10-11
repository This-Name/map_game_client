package com.project.mapgames.model.dataGame

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Task(
    @SerialName("coords")
    val coords: Coords = Coords(),
    @SerialName("description")
    val description: String = "",
    @SerialName("id")
    val id: Int = 0,
    @SerialName("next_task")
    val next_task: Int? = 0,
    @SerialName("title")
    val title: String = ""
) : Parcelable