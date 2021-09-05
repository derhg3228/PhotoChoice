package com.example.photochanger.data.model

import com.google.gson.annotations.SerializedName

data class PhotoModelDto(
    @SerializedName("media_url")
    val mediaUrl: String
)