package com.example.photochanger.di

import com.example.photochanger.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProfileViewModel(get()) }
}