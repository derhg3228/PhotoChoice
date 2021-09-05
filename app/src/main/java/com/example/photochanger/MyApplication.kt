package com.example.photochanger

import android.app.Application
import com.example.photochanger.di.apiModule
import com.example.photochanger.di.repositoryModule
import com.example.photochanger.di.useCaseModule
import com.example.photochanger.di.viewModelModule
import com.facebook.appevents.AppEventsLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initModules()

        AppEventsLogger.activateApp(this)
    }

    private fun initModules(){
        startKoin{
            androidContext(this@MyApplication)
            modules(listOf(apiModule, repositoryModule, useCaseModule, viewModelModule))
        }
    }
}