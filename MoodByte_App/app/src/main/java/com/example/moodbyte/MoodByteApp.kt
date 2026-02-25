package com.example.moodbyte

import android.app.Application
import com.example.moodbyte.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoodByteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MoodByteApp)
            modules(appModule)
        }
    }
}