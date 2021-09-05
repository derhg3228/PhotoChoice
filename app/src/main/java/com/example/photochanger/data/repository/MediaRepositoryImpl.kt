package com.example.photochanger.data.repository

import com.example.photochanger.data.api.FacebookApiService
import com.example.photochanger.data.model.PhotoModelDto
import com.example.photochanger.domain.repository.MediaRepository
import io.reactivex.Single

class MediaRepositoryImpl(private val apiService: FacebookApiService) : MediaRepository {

    override fun getMedias(): Single<List<PhotoModelDto>> {
        return apiService.getUserId()
            .flatMap { apiService.getInstagramBusinessId(it.data.first().id) }
            .flatMap { apiService.getMediaResources(it.instagram_business_account.id) }
            .flatMap { media_model ->
                Single.concat(media_model.data.map { apiService.getPhotoUrl(it.id) }).toList()
            }
    }

}