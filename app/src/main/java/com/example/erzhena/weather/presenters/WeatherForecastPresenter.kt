package com.example.erzhena.weather.presenters

import com.example.erzhena.weather.api.WeatherService
import com.example.erzhena.weather.base.presenters.BasePresenter
import com.example.erzhena.weather.contracts.WeatherForecastContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherForecastPresenter(private val weatherService: WeatherService) :
    WeatherForecastContract.Presenter,
    BasePresenter<WeatherForecastContract.View>() {

    override fun loadForecast(cityId: String) {
        weatherService.getWeatherForecast(cityId)
            .map { it.forecast }
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