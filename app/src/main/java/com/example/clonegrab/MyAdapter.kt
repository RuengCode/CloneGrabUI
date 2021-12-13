package com.example.clonegrab

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newsList : ArrayList<News>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item2,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.imgFood.setImageResource(currentItem.imgFood)
        holder.nameFood.text = currentItem.nameFood
        holder.priceFood.text = currentItem.priceFood

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imgFood : ImageView = itemView.findViewById(R.id.imgFood)
        val nameFood : TextView = itemView.findViewById(R.id.nameFood)
        val priceFood : TextView = itemView.findViewById(R.id.priceFood)

    }
}