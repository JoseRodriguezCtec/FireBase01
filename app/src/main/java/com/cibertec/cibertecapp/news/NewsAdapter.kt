package com.cibertec.cibertecapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(): RecyclerView.Adapter<NewsViewHolder>() {

    private var newsList = emptyList<News>()

    fun setNews(news: List<News>) {
        newsList = news
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int =  newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: News = newsList[position]
        holder.data(news)
    }

}