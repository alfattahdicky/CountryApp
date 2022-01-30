package com.example.countryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewCountryAdapter (private val listCountry: ArrayList<Country>) :
    RecyclerView.Adapter<CardViewCountryAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_country, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CardViewViewHolder,
        position: Int
    ) {
        val country = listCountry[position]

        Glide.with(holder.itemView.context)
            .load(country.photo)
            .into(holder.imgPhoto)

        holder.titleCountry.text = country.name
        holder.shortTextCountry.text = country.detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listCountry[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listCountry.size
    }

    inner class CardViewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_flag)
        var titleCountry: TextView = itemView.findViewById(R.id.title_country)
        var shortTextCountry: TextView = itemView.findViewById(R.id.short_text_country)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Country)
    }
}