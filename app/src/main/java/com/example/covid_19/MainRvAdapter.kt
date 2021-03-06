package com.example.covid_19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainRvAdapter(val context: Context, val list: ArrayList<Model>) : RecyclerView.Adapter<MainRvAdapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainRvAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.mian_rv_item, p0, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(p0: MainRvAdapter.Holder, p1: Int) {
        if(itemClick != null) {
            p0?.itemView.setOnClickListener { v ->
                itemClick?.onClick(v, p1)
            }
        }

        p0.bind(list[p1], context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo = itemView?.findViewById<ImageView>(R.id.image_area)
        val title = itemView?.findViewById<TextView>(R.id.text_area)

        fun bind(model: Model, context: Context) {
            title.text = model.title
            Picasso.get().load(model.image).into(photo)
        }
    }
}