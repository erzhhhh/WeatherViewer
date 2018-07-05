package com.example.erzhena.weather.contracts

import com.example.erzhena.weather.base.presenters.MvpPresenter
import com.example.erzhena.weather.base.view.MvpView
import com.example.erzhena.weather.models.ForecastItem

interface WeatherForecastContract {

    interface View : MvpView {

        fun showContent(forecast : List<ForecastItem>)

        fun showError()
    }

    interface Presenter : MvpPresenter<View> {

        fun loadForecast(cityId: String)
    }
}