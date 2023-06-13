package com.example.travelyour

import android.app.Application

class CoreApp:Application() {
    override fun onCreate() {
        super.onCreate()
            Locator.initWith(this)
    }
}