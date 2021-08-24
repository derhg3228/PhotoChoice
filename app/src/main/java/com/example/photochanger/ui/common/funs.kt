package com.example.photochanger.ui.common

import com.facebook.AccessToken

fun isProfileAuth(): Boolean = run {
    val accessToken = AccessToken.getCurrentAccessToken()
    accessToken != null && !accessToken.isExpired
}