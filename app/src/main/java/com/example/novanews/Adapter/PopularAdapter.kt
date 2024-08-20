package com.example.novanews.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.novanews.Modal.SubnewsItem
import com.example.novanews.databinding.NewstileBinding

class PopularAdapter(val newsPopular: List<SubnewsItem?>?): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    class PopularViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var binding : NewstileBinding = NewstileBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
       var view = NewstileBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PopularViewHolder(view.root)
    }

    override fun getItemCount(): Int {
       return newsPopular?.size?:itemCount
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.binding.titlenews.text = newsPopular?.get(position)?.title ?: ""
        holder.binding.datenews.text = newsPopular?.get(position)?.timestamp ?: ""
        Glide.with(holder.itemView.context).load(newsPopular?.get(position)?.images).into(holder.binding.imgnews)

    }
}