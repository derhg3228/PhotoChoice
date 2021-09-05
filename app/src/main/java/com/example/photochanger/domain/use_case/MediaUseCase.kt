package com.example.photochanger.domain.use_case

import com.example.photochanger.domain.model.PhotoModel
import io.reactivex.Single

interface MediaUseCase {

    fun getMedias(): Single<List<PhotoModel>>
}