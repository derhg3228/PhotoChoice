package com.example.photochanger.domain.repository

import com.example.photochanger.data.model.PhotoModelDto
import io.reactivex.Single

interface MediaRepository {

    fun getMedias(): Single<List<PhotoModelDto>>
}