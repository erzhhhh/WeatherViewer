package com.example.erzhena.weather.models

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("list")
    val locations: List<Location>
)

data class Location(
    val id: Int,
    val name: String,
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val temp_min: Double,
    val temp_max: Double
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

