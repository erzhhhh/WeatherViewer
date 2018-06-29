package com.example.erzhena.weather.base.presenters

import android.support.annotation.UiThread
import com.example.erzhena.weather.base.view.MvpView

interface MvpPresenter<in V : MvpView> {

    @UiThread
    fun attachView(view: V)

    @UiThread
    fun detachView()
}
