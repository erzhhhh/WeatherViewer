package com.example.erzhena.weather.di.components

import android.content.Context
import com.example.erzhena.weather.activities.MainActivity
import com.example.erzhena.weather.api.WeatherService
import com.example.erzhena.weather.di.modules.AppModule
import com.example.erzhena.weather.presenters.WeatherPresenter
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {
    //на протяжении жизни компонента будет возвращаться один и тот же объект из AppModule
    //компонент будет хранить в себе синглтон нижеперечисленных объектов
    fun exposeRetrofit(): Retrofit

    fun exposeContext(): Context

    fun injects(target: MainActivity)

    fun injects(target: WeatherPresenter)

    fun injects(target: WeatherService)
}