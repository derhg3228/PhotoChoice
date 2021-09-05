package com.example.photochanger.di

import com.example.photochanger.data.repository.MediaRepositoryImpl
import com.example.photochanger.domain.repository.MediaRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MediaRepository> { MediaRepositoryImpl(get()) }
}