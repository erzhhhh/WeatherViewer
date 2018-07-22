package com.example.erzhena.weather

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.erzhena.weather.activities.WeatherForecastActivity
import com.example.erzhena.weather.base.constants.Constants
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherForecastActivityTest {

    fun provideActivityIntent(): Intent =
        Intent()
            .putExtra(Constants.CITY_ID, "545782")
            .putExtra(Constants.CITY_NAME, "Butovo")
            .putExtra(Constants.CURRENT_WEATHER, "04d")


    @Rule @JvmField
    val activityRule = ActivityTestRule(WeatherForecastActivity::class.java)


    @Before
    @Throws(Exception::class)
    fun setUp() {

    }
}