package com.example.novanews.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.novanews.Modal.ModalClass
import com.example.novanews.R

class CitySearchAdapter(val cityList: List<ModalClass>, val listener: (ModalClass) -> Unit) :
    RecyclerView.Adapter<CitySearchAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityName = itemView.findViewById<TextView>(R.id.cityName)

        fun bind(city: ModalClass, listener: (ModalClass) -> Unit){
            cityName.text = city.cityName
            itemView.setOnClickListener {
                listener(city)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.citysearchtile, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return cityList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val city = cityList[position]
        holder.cityName.text = city.cityName
//        holder.itemView.setOnClickListener {
//            listener(city)
//        }
        holder.bind(city, listener)
    }
}