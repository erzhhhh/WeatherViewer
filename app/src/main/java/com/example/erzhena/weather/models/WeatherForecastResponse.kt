package com.example.erzhena.weather.models

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("list")
    val forecast: List<ForecastItem>
)

data class ForecastItem(
    val dt: Int,
    val main: Main1,
    val weather: List<ForecastWeather1>
)

data class Main1(
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double
)

data class ForecastWeather1(
    val description: String,
    val icon: String
)
