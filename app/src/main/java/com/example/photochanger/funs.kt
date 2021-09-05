package com.example.photochanger

import android.widget.ImageView
import com.facebook.AccessToken
import com.squareup.picasso.Picasso

fun isProfileAuth(): Boolean = run {
    val accessToken = AccessToken.getCurrentAccessToken()
    accessToken != null && !accessToken.isExpired
}

fun getAccessToken(): String? = AccessToken.getCurrentAccessToken()?.token

fun ImageView.downloadAndSetImage(url: String) {
    Picasso.get()
        .load(url)
        .fit()
        .into(this)
}