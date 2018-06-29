package com.example.erzhena.weather.contracts

import com.example.erzhena.weather.base.presenters.MvpPresenter
import com.example.erzhena.weather.base.view.MvpView
import com.example.erzhena.weather.models.Location

interface WeatherContract {

    interface View : MvpView {

        fun showContent(location : List<Location>)

        fun showError()
    }

    interface Presenter : MvpPresenter<View> {

        fun load()
    }
}