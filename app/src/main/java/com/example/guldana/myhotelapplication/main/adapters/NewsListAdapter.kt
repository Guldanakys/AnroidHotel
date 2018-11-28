package com.example.guldana.myhotelapplication.main.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guldana.myhotelapplication.R
import com.example.guldana.myhotelapplication.models.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*

class NewsListAdapter(private val news: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        p0.itemView.title.text = news[p1].title
        p0.itemView.desc.text = news[p1].desc
        Picasso.get().load(news[p1].imgUrl).into(p0.itemView.news_image)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(LayoutInflater.from(p0.context)
                .inflate(R.layout.news_list_item, p0, false))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    class NewsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)
}