package com.droiddev.cleanarchitecture.app

import android.app.Application
import com.droiddev.cleanarchitecture.di.AppComponent
import com.droiddev.cleanarchitecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .context(context = this)
            .build()
    }
}