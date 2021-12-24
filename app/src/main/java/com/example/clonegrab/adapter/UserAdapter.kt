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


class UserAdapter(private val list: ArrayList<CoinsItem>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    inner class UserViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        var userID: TextView
        var name: TextView
        var coinType: TextView
        var coinPrice: TextView
        var imgItem: ImageView


        init {
            userID = itemView.findViewById(R.id.coinId)
            name = itemView.findViewById(R.id.coinName)
            coinType = itemView.findViewById(R.id.coinType)
            coinPrice = itemView.findViewById(R.id.coinPrice)
            imgItem = itemView.findViewById(R.id.flagImg)

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.coins_list_row, parent, false)

        return UserViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.userID.text = list[position].id.toString()
        holder.name.text = list[position].name
        holder.coinType.text = list[position].type
        holder.coinPrice.text = list[position].price


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