package com.example.koinex

import android.app.Application
import com.example.koinex.ex1.appModule
import com.example.koinex.ex1.applicationModule
import com.example.koinex.ex1.carModule
import com.example.koinex.ex1.helloModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, applicationModule, carModule, helloModule))
        }
    }
}