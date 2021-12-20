package com.example.clonegrab.adapter

import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.clonegrab.R
import com.example.clonegrab.data.MyDataItem
import com.example.clonegrab.data.CoinsItem
import com.squareup.picasso.Picasso



class UserAdapter(private val  list : ArrayList<CoinsItem>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var userID: TextView
        var title: TextView
        var imgItem: ImageView


        init {
            userID = itemView.findViewById(R.id.userID)
            title = itemView.findViewById(R.id.title)
            imgItem = itemView.findViewById(R.id.image_kub)

        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.userID.text = list[position].id.toString()
        holder.title.text = list[position].name


        val imgItem = holder.imgItem.loadSvg(list[position].iconUrl!!)

//
//        Picasso.get()
//            .load(list[position].iconUrl).into(imgItem)
    }

    override fun getItemCount(): Int = list.size

    fun ImageView.loadSvg(url: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
            .build()

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)
    }

}