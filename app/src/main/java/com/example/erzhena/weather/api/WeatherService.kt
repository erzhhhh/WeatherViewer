package com.example.erzhena.weather.api

import com.example.erzhena.weather.models.ForecastResponse
import com.example.erzhena.weather.models.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/find?lat=55.5&lon=37.5&cnt=50&appid=f57a671f96b0ade234b6ec42dc26b1e5")
    fun getWeather() : Observable<Response>

    @GET("data/2.5/forecast?appid=f57a671f96b0ade234b6ec42dc26b1e5")
    fun getWeatherForecast(@Query("id") cityId: String): Observable<ForecastResponse>
}