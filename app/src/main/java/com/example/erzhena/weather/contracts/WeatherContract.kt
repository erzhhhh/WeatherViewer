package com.example.erzhena.weather.contracts

import com.example.erzhena.weather.base.presenters.MvpPresenter
import com.example.erzhena.weather.base.view.MvpView
import com.example.erzhena.weather.models.WeatherList

interface WeatherContract {

    interface View : MvpView {

        fun showContent(weather : List<WeatherList>)

        fun showError()
    }

    interface Presenter : MvpPresenter<View> {

        fun load()
    }
}