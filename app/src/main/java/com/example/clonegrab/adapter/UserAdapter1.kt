package com.example.clonegrab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.R
import com.example.clonegrab.model.UserModelClass1
import com.squareup.picasso.Picasso

class UserAdapter1(val context: Context, val items: ArrayList<UserModelClass1>) : RecyclerView.Adapter<UserAdapter1.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_view2,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: UserAdapter1.ViewHolder, position: Int) {
        val item = items.get(position)

        holder.nameFood.text = item.name
        holder.desFood.text = item.description
        holder.priceFood.text = item.price.toString()

        val imgFood = holder.imgFood
        Picasso.get()
            .load(item.image).into(imgFood)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameFood = view.findViewById<TextView>(R.id.nameFood)
        val priceFood = view.findViewById<TextView>(R.id.priceFood)
        val desFood = view.findViewById<TextView>(R.id.desFood)
        val imgFood = view.findViewById<ImageView>(R.id.imgFood)

    }

}