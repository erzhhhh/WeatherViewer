package com.example.erzhena.weather.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.erzhena.weather.App
import com.example.erzhena.weather.R
import com.example.erzhena.weather.adapters.WeatherAdapter
import com.example.erzhena.weather.contracts.WeatherContract
import com.example.erzhena.weather.models.Location
import kotlinx.android.synthetic.main.activity_main.recyclerView
import javax.inject.Inject


open class MainActivity :
    AppCompatActivity(),
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
        recyclerView.adapter = adapter

        presenter.attachView(this)
        load()
    }

    private fun load() {
        presenter.load()
    }

    override fun showContent(location : List<Location>) {
        adapter.setItems(location)
    }

    override fun showError() {
    }
}
