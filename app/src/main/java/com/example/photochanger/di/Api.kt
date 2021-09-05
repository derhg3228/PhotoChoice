package com.example.photochanger.di

import com.example.photochanger.data.api.FacebookApiService
import com.example.photochanger.data.api.RetrofitInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { getFacebookApiService(getRetrofit()) }
}

private const val BASE_URL = "https://graph.facebook.com/v11.0/"

//private fun getInterceptor() = RetrofitInterceptor()

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

private fun getFacebookApiService(retrofit: Retrofit): FacebookApiService =
    retrofit.create(FacebookApiService::class.java)