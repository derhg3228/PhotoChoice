package com.example.photochanger.domain.use_case

import com.example.photochanger.domain.model.PhotoModel
import com.example.photochanger.domain.model.toEntity
import com.example.photochanger.domain.repository.MediaRepository
import io.reactivex.Single

class MediaUseCaseImpl(
    private val repository: MediaRepository
): MediaUseCase {

    override fun getMedias(): Single<List<PhotoModel>> {
        return repository.getMedias().map { list -> list.map { it.toEntity() } }
    }
}