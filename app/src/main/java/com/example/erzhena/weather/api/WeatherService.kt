package com.example.erzhena.weather.api

import com.example.erzhena.weather.models.Weather
import io.reactivex.Observable
import retrofit2.http.GET

interface WeatherService {

    @GET("data/2.5/find?lat=55.5&lon=37.5&cnt=50&appid=f57a671f96b0ade234b6ec42dc26b1e5")
    fun getWeather() : Observable<Weather>
}