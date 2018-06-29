package com.example.erzhena.weather.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.erzhena.weather.R
import com.example.erzhena.weather.models.WeatherList
import kotlinx.android.synthetic.main.weather_item.view.high_temperature
import kotlinx.android.synthetic.main.weather_item.view.low_temperature


class WeatherAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<WeatherList>()
    private var onItemClickListener: ((WeatherList) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pm = items[position]
        (holder as WeatherItemViewHolder).bind(pm, onItemClickListener)
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<WeatherList>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private class WeatherItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.weather_item, parent, false)) {

        fun bind(pm: WeatherList, listener: ((WeatherList) -> Unit)?) {
            with(itemView) {
                setOnClickListener { listener?.invoke(pm) }
                high_temperature.text = pm.main.temp_max.toString()
                low_temperature.text = pm.main.temp_min.toString()
            }
        }
    }
}