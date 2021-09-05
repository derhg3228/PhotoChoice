package com.example.photochanger.data.api

import com.example.photochanger.data.model.DataModelDto
import com.example.photochanger.data.model.InstagramBusinessModelDto
import com.example.photochanger.data.model.MediaModelDto
import com.example.photochanger.data.model.PhotoModelDto
import com.example.photochanger.getAccessToken
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FacebookApiService{

    companion object{
        private val ACCESS_TOKEN = getAccessToken()
        private const val QUERY_BUSINESS = "instagram_business_account"
        private const val MEDIA_URL = "media_url"
    }

    @GET("me/accounts")
    fun getUserId(
        @Query("access_token") accessToken: String? = ACCESS_TOKEN
    ): Single<DataModelDto>

    @GET("{page_id}")
    fun getInstagramBusinessId(
        @Path("page_id") page_id: String,
        @Query("fields") fields: String = QUERY_BUSINESS,
        @Query("access_token") accessToken: String? = ACCESS_TOKEN

    ): Single<InstagramBusinessModelDto>

    @GET("/{business_id}/media")
    fun getMediaResources(
        @Path("business_id") businessId: String,
        @Query("access_token") accessToken: String? = ACCESS_TOKEN
    ): Single<MediaModelDto>

    @GET("/{media-id}")
    fun getPhotoUrl(
        @Path("media-id") photoId: String,
        @Query("fields") fields: String = MEDIA_URL,
        @Query("access_token") accessToken: String? = ACCESS_TOKEN
    ): Single<PhotoModelDto>
}