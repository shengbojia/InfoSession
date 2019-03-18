package com.shengbojia.uwaterlooinfosession.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class InfoSession(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("employer")
    val employer: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val day: String,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("end_time")
    val endTime: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("building")
    val building: Building
)