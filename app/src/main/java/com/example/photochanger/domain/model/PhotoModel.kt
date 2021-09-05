package com.example.photochanger.domain.model

import com.example.photochanger.data.model.PhotoModelDto

data class PhotoModel(
    val mediaUrl: String
)

fun PhotoModelDto.toEntity(): PhotoModel = PhotoModel(mediaUrl)