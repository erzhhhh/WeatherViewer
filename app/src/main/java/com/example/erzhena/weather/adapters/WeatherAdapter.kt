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
                temperature.text = Math.round(pm.main.temp/10).toString()
                city.text = pm.name
                when {
                    pm.weather[0].id == 800 -> weather_icon.setImageResource(R.drawable.art_clear)
                    pm.weather[0].id == 900 -> weather_icon.setImageResource(R.drawable.art_clouds)
                    pm.weather[0].id == 700 -> weather_icon.setImageResource(R.drawable.art_fog)
                }

            }
        }
    }
}