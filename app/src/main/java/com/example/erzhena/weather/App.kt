package com.example.erzhena.weather

import android.app.Application
import com.example.erzhena.weather.di.components.AppComponent
import com.example.erzhena.weather.di.components.DaggerAppComponent
import com.example.erzhena.weather.di.modules.AppModule

class App : Application() {

    companion object {

        private lateinit var instance: App

        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        instance = this
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this, "http://api.openweathermap.org"))
            .build()
        super.onCreate()
    }
}