package com.example.photochanger.data.api

import com.example.photochanger.getAccessToken
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RetrofitInterceptor: Interceptor {

    companion object{
        private val ACCESS_TOKEN = getAccessToken()
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()

        // Настраиваем запросы
        val request: Request = original.newBuilder()
            .headers(original.headers())
            .url("${original.url()}&access_token=$ACCESS_TOKEN")
            .method(original.method(), original.body())
            .build()

        return chain.proceed(request)

    }
}