package com.example.erzhena.weather

fun getCurrentIcon(iconId : String)  : Int {
    when (iconId) {
        "01d", "01n" -> return R.drawable.art_clear
        "02d", "02n" -> return R.drawable.art_light_clouds
        "03d", "03n" -> return R.drawable.art_light_clouds
        "04d", "04n" -> return R.drawable.art_clouds
        "09d", "09n" -> return R.drawable.art_rain
        "10d", "10n" -> return R.drawable.art_light_rain
        "11d", "11n" -> return R.drawable.art_storm
        "13d", "13n" -> return R.drawable.art_snow
        "50d", "50n" -> return R.drawable.art_fog
    }
    return  -1
}

fun setCurrentImage(imageId :String) : Int {
    when (imageId) {
        "01d", "01n" -> return R.drawable.ic_sun
        "02d", "02n" -> return R.drawable.ic_light_clouds
        "03d", "03n" -> return R.drawable.ic_light_clouds
        "04d", "04n" -> return R.drawable.ic_clouds
        "09d", "09n" -> return R.drawable.ic_rain
        "10d", "10n" -> return R.drawable.ic_light_rain
        "11d", "11n" -> return R.drawable.ic_storm
        "13d", "13n" -> return R.drawable.ic_snow
        "50d", "50n" -> return R.drawable.ic_fog
    }
    return -1
}