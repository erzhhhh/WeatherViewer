package com.example.erzhena.weather.presenters

import com.example.erzhena.weather.api.WeatherService
import com.example.erzhena.weather.base.presenters.BasePresenter
import com.example.erzhena.weather.contracts.WeatherContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(private val weatherService: WeatherService) :
    WeatherContract.Presenter,
    BasePresenter<WeatherContract.View>() {

    override fun loadWeather() {
        weatherService.getWeather()
            .map { it.locations }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { view?.showContent(it) },
                {
                    view?.showError()
                }
            )
    }
}