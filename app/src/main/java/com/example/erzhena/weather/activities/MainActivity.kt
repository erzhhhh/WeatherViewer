package com.example.erzhena.weather.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.erzhena.weather.App
import com.example.erzhena.weather.R
import com.example.erzhena.weather.adapters.WeatherAdapter
import com.example.erzhena.weather.base.BaseActivity
import com.example.erzhena.weather.base.constants.Constants.CITY_ID
import com.example.erzhena.weather.base.constants.Constants.CITY_NAME
import com.example.erzhena.weather.base.constants.Constants.CURRENT_WEATHER
import com.example.erzhena.weather.contracts.WeatherContract
import com.example.erzhena.weather.models.Location
import kotlinx.android.synthetic.main.activity_main.recyclerView
import javax.inject.Inject


open class MainActivity :
    BaseActivity(),
    WeatherContract.View {

    @Inject
    lateinit var presenter: WeatherContract.Presenter
    private lateinit var adapter : WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.injects(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = WeatherAdapter()
        adapter.onItemClickListener = {
            val intent = Intent(this@MainActivity, WeatherForecastActivity::class.java)
                .putExtra(CITY_ID, it.id.toString())
                .putExtra(CITY_NAME, it.name)
                .putExtra(CURRENT_WEATHER, it.weather[0].icon)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        presenter.attachView(this)
        load()
    }

    private fun load() {
        presenter.loadWeather()
    }

    override fun showContent(location : List<Location>) {
        adapter.setItems(location)
    }

    override fun showError() {
    }
}
