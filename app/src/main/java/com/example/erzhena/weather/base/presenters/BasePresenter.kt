package com.example.erzhena.weather.base.presenters

import android.support.annotation.UiThread
import com.example.erzhena.weather.base.presenters.MvpPresenter
import com.example.erzhena.weather.base.view.MvpView
import java.lang.ref.WeakReference


open class BasePresenter<V : MvpView> : MvpPresenter<V> {

    private var viewRef: WeakReference<V>? = null

    @UiThread
    override fun attachView(view: V) {
        viewRef = WeakReference(view)
    }

    open var view: V? = null
        get() = viewRef?.get()

    @UiThread
    override fun detachView() {
        viewRef?.clear()
        viewRef = null
    }
}