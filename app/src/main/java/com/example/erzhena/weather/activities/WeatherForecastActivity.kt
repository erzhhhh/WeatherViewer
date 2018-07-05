package com.example.erzhena.weather.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.erzhena.weather.App
import com.example.erzhena.weather.R
import com.example.erzhena.weather.adapters.WeatherForecastAdapter
import com.example.erzhena.weather.base.BaseActivity
import com.example.erzhena.weather.contracts.WeatherForecastContract
import com.example.erzhena.weather.models.ForecastItem
import kotlinx.android.synthetic.main.activity_detail.collapsing_toolbar
import kotlinx.android.synthetic.main.activity_detail.detailRecyclerView
import kotlinx.android.synthetic.main.activity_detail.toolbar
import javax.inject.Inject


open class WeatherForecastActivity :
    BaseActivity(),
    WeatherForecastContract.View {

    @Inject
    lateinit var presenter: WeatherForecastContract.Presenter
    private lateinit var adapter : WeatherForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.injects(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)
        if(supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        val linearLayoutManager = LinearLayoutManager(this)
        detailRecyclerView.layoutManager = linearLayoutManager
        adapter = WeatherForecastAdapter()
        detailRecyclerView.adapter = adapter
        collapsing_toolbar.title = intent.getStringExtra("CITYNAME")

        presenter.attachView(this)
        loadForecastWeather(intent.getStringExtra("CITYID"))
    }

    private fun loadForecastWeather(cityId: String) {
        presenter.loadForecast(cityId)
    }

    override fun showContent(forecast : List<ForecastItem>) {
        adapter.setItems(forecast)
    }

    override fun showError() {
    }
}