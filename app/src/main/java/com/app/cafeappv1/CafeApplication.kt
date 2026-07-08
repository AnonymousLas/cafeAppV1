package com.app.cafeappv1

import android.app.Application
import com.app.cafeappv1.di.AppContainer

class CafeApplication : Application() {
    lateinit var container : AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer()
    }
}