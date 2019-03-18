package com.shengbojia.uwaterlooinfosession.model

import com.google.gson.annotations.SerializedName

data class Building(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("room")
    val room: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("map_url")
    val mapUrl: String
)