package com.example.erzhena.weather.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.erzhena.weather.R
import com.example.erzhena.weather.models.ForecastItem
import kotlinx.android.synthetic.main.forecast_list_item.view.forecastDate
import kotlinx.android.synthetic.main.forecast_list_item.view.forecast_weather_description
import kotlinx.android.synthetic.main.forecast_list_item.view.low_temperature
import kotlinx.android.synthetic.main.weather_item.view.high_temperature
import kotlinx.android.synthetic.main.weather_item.view.weather_icon
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
                high_temperature.text = "${Math.round(pm.main.temp_max / 10)}\u00b0"
                low_temperature.text = "${Math.round(pm.main.temp_min / 10)}\u00b0"
                forecastDate.text = getDateTime(pm.dt)
                forecast_weather_description.text = pm.weather[0].description
                when {
                    pm.weather[0].icon == "01d" || pm.weather[0].icon == "01n" -> weather_icon.setImageResource(R.drawable.art_clear)
                    pm.weather[0].icon == "02d" || pm.weather[0].icon == "02n" -> weather_icon.setImageResource(R.drawable.art_light_clouds)
                    pm.weather[0].icon == "03d" || pm.weather[0].icon == "03n" -> weather_icon.setImageResource(R.drawable.art_light_clouds)
                    pm.weather[0].icon == "04d" || pm.weather[0].icon == "04n" -> weather_icon.setImageResource(R.drawable.art_clouds)
                    pm.weather[0].icon == "09d" || pm.weather[0].icon == "09n" -> weather_icon.setImageResource(R.drawable.art_rain)
                    pm.weather[0].icon == "10d" || pm.weather[0].icon == "10n" -> weather_icon.setImageResource(R.drawable.art_light_rain)
                    pm.weather[0].icon == "11d" || pm.weather[0].icon == "11n" -> weather_icon.setImageResource(R.drawable.art_storm)
                    pm.weather[0].icon == "13d" || pm.weather[0].icon == "13n" -> weather_icon.setImageResource(R.drawable.art_snow)
                    pm.weather[0].icon == "50d" || pm.weather[0].icon == "50n" -> weather_icon.setImageResource(R.drawable.art_fog)
                }
            }
        }

        @SuppressLint("SimpleDateFormat")
        private fun getDateTime(timeStamp: Int) : String {
            val date = Date(timeStamp * 1000L)
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
//            sdf.timeZone = java.util.TimeZone.getTimeZone("GMT-4")
            return simpleDateFormat.format(date)
        }
    }
}