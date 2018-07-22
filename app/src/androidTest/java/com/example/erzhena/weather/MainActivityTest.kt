package com.example.erzhena.weather

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.erzhena.weather.activities.MainActivity
import com.example.erzhena.weather.activities.WeatherForecastActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {

    }

    @Test
    fun onLoad() {
        onView(withText("Weather")).check(matches(isDisplayed()))
        onView(withText("Butovo")).check(matches(isDisplayed()))

    }

    @Test
    fun onClickRecyclerItem() {
        Intents.init()
        onView(withText("Butovo")).perform(click())
        Intents.intended(hasComponent(WeatherForecastActivity::class.java.name))
        Intents.release()

    }
}