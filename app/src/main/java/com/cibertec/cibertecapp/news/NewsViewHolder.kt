package com.cibertec.cibertecapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cibertec.cibertecapp.R

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup):
RecyclerView.ViewHolder(inflater.inflate(R.layout.item_news, parent, false)){

    private var imgNews: ImageView ? = null
    private var textTitleNews: TextView ? = null
    private var textDescriptionNews: TextView ? = null

    init {
        imgNews = itemView.findViewById(R.id.imgNews)
        textTitleNews = itemView.findViewById(R.id.textTitleNews)
        textDescriptionNews = itemView.findViewById(R.id.textDescriptionNews)
    }

    fun data(news: News) {
        textTitleNews?.text = news.titulo
        textDescriptionNews?.text = news.contenido

        imgNews?.let {
            Glide.with(it)
                .load(news.imagen)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder_error)
                .into(it)
        }
    }

}