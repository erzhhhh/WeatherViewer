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
import kotlinx.android.synthetic.main.activity_detail.imageView
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
        setCurrentImage(intent.getStringExtra("CURRENT_WEATHER"))

        presenter.attachView(this)
        loadForecastWeather(intent.getStringExtra("CITYID"))
    }

    private fun setCurrentImage(stringExtra: String?) {
        when (stringExtra) {
            "01d", "01n" -> imageView.setImageResource(R.drawable.ic_sun)
            "02d", "02n" -> imageView.setImageResource(R.drawable.ic_light_clouds)
            "03d", "03n" -> imageView.setImageResource(R.drawable.ic_light_clouds)
            "04d", "04n" -> imageView.setImageResource(R.drawable.ic_clouds)
            "09d", "09n" -> imageView.setImageResource(R.drawable.ic_rain)
            "10d", "10n" -> imageView.setImageResource(R.drawable.ic_light_rain)
            "11d", "11n" -> imageView.setImageResource(R.drawable.ic_storm)
            "13d", "13n" -> imageView.setImageResource(R.drawable.ic_snow)
            "50d", "50n" -> imageView.setImageResource(R.drawable.ic_fog)
        }
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
