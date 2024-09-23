package com.example.sanpa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project135.domain.TrendsDomian
import com.example.sanpa.R

class TrendsAdapter(private val trends: List<TrendsDomian>) : RecyclerView.Adapter<TrendsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trend, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trend = trends[position]
        holder.title.text = trend.title
        holder.subtitle.text = trend.subtitle

        // Load local image
        holder.pic.setImageResource(trend.picResId)
    }

    override fun getItemCount(): Int {
        return trends.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTxt)
        val subtitle: TextView = itemView.findViewById(R.id.subtitleTxt)
        val pic: ImageView = itemView.findViewById(R.id.pic)
    }
}
