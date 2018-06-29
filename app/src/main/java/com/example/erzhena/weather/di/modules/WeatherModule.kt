package com.example.erzhena.weather.di.modules

import com.example.erzhena.weather.api.WeatherService
import com.example.erzhena.weather.contracts.WeatherContract
import com.example.erzhena.weather.presenters.WeatherPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class WeatherModule {

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    fun provideWeatherPresenter(service: WeatherService): WeatherContract.Presenter = WeatherPresenter(service)
}
