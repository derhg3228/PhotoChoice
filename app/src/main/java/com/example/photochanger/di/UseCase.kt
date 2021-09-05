package com.example.photochanger.di

import com.example.photochanger.domain.use_case.MediaUseCase
import com.example.photochanger.domain.use_case.MediaUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<MediaUseCase> { MediaUseCaseImpl(get()) }
}