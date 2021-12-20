package com.example.clonegrab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.R
import com.example.clonegrab.activity.RattingActivity
import com.example.clonegrab.activity.ShowActivity
import com.example.clonegrab.data.MyDataItem
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController
import com.squareup.picasso.Picasso

class MyAdapter(

    val context: Context, val userList: List<MyDataItem>
) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var userID: TextView
        var title: TextView
        var imgItem: ImageView


        init {
            userID = itemView.findViewById(R.id.userID)
            title = itemView.findViewById(R.id.title)
            imgItem = itemView.findViewById(R.id.image_kub)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.userID.text = userList[position].id.toString()
        holder.title.text = userList[position].title

        val imgItem = holder.imgItem
        Picasso.get()
            .load(userList[position].url).into(imgItem)

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}