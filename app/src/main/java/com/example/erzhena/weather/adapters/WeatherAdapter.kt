package com.example.erzhena.weather.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.erzhena.weather.R
import com.example.erzhena.weather.models.Location
import kotlinx.android.synthetic.main.weather_item.view.city
import kotlinx.android.synthetic.main.weather_item.view.temperature
import kotlinx.android.synthetic.main.weather_item.view.weather_description
import kotlinx.android.synthetic.main.weather_item.view.weather_icon


class WeatherAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<Location>()
    private var onItemClickListener: ((Location) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pm = items[position]
        (holder as WeatherItemViewHolder).bind(pm, onItemClickListener)
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<Location>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private class WeatherItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.weather_item, parent, false)) {

        fun bind(pm: Location, listener: ((Location) -> Unit)?) {
            with(itemView) {
                setOnClickListener { listener?.invoke(pm) }
                weather_description.text = pm.weather[0].description
                temperature.text = "${Math.round(pm.main.temp / 10)}\u00b0"
                city.text = pm.name
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
    }
}