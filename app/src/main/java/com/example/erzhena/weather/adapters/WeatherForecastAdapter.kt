package com.example.erzhena.weather.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.erzhena.weather.R
import com.example.erzhena.weather.getCurrentIcon
import com.example.erzhena.weather.models.ForecastItem
import kotlinx.android.synthetic.main.forecast_list_item.view.forecastDate
import kotlinx.android.synthetic.main.forecast_list_item.view.forecastWeatherDescription
import kotlinx.android.synthetic.main.forecast_list_item.view.lowTemperature
import kotlinx.android.synthetic.main.weather_item.view.highTemperature
import kotlinx.android.synthetic.main.weather_item.view.weatherIcon
import java.text.SimpleDateFormat
import java.util.Date


class WeatherForecastAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<ForecastItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pm = items[position]
        (holder as WeatherItemViewHolder).bind(pm)
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<ForecastItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private class WeatherItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.forecast_list_item, parent, false)) {

        fun bind(pm: ForecastItem) {
            with(itemView) {
                highTemperature.text = "${Math.round(pm.main.temp_max / 10)}\u00b0"
                lowTemperature.text = "${Math.round(pm.main.temp_min / 10)}\u00b0"
                forecastDate.text = getDateTime(pm.dt)
                forecastWeatherDescription.text = pm.weather[0].description
                weatherIcon.setImageResource(getCurrentIcon(pm.weather[0].icon))
            }
        }

        @SuppressLint("SimpleDateFormat")
        private fun getDateTime(timeStamp: Int) : String {
            val date = Date(timeStamp * 1000L)
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return simpleDateFormat.format(date)
        }
    }
}