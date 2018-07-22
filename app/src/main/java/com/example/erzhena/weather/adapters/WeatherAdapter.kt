package com.example.erzhena.weather.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.erzhena.weather.R
import com.example.erzhena.weather.getCurrentIcon
import com.example.erzhena.weather.models.Location
import kotlinx.android.synthetic.main.weather_item.view.date
import kotlinx.android.synthetic.main.weather_item.view.highTemperature
import kotlinx.android.synthetic.main.weather_item.view.weatherDescription
import kotlinx.android.synthetic.main.weather_item.view.weatherIcon


class WeatherAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<Location>()
    var onItemClickListener: ((Location) -> Unit)? = null

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
                weatherDescription.text = pm.weather.first().description
                highTemperature.text = "${Math.round(pm.main.temp_max / 10)}\u00b0"
                date.text = pm.name
                weatherIcon.setImageResource(getCurrentIcon(pm.weather[0].icon))
            }
        }
    }
}