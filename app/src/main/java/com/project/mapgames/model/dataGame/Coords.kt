package com.project.mapgames.model.dataGame

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Coords(
    @SerialName("x")
    val x: Double = 0.0,
    @SerialName("y")
    val y: Double = 0.0
) : Parcelable
