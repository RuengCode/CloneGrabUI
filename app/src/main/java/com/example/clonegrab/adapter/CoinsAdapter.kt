package com.example.clonegrab.adapter

import android.app.Activity
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.clonegrab.R
import com.example.clonegrab.data.CoinsModel

import com.squareup.picasso.Picasso


class CoinsAdapter(val activity : Activity) : RecyclerView.Adapter<CoinsAdapter.MyViewHolder>() {

    private var coinsList: List<CoinsModel>? = null

    fun setCoins(coinsList: List<CoinsModel>) {
        this.coinsList = coinsList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coins_list_row,parent,false)
        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: CoinsAdapter.MyViewHolder, position: Int) {
        holder.bind(coinsList?.get(position)!!, activity)

    }

    override fun getItemCount(): Int {
        if(coinsList == null)return 0
        else return coinsList?.size!!


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagImg = itemView.findViewById<ImageView>(R.id.flagImg)
        val coinId = itemView.findViewById<TextView>(R.id.coinId)
        val coinName = itemView.findViewById<TextView>(R.id.coinName)
        val coinType = itemView.findViewById<TextView>(R.id.coinType)
        val coinPrice = itemView.findViewById<TextView>(R.id.coinPrice)

        fun bind(data: CoinsModel, activity: Activity) {
            coinId.text = data.id.toString()
            coinName.text = data.nameTh
            coinType.text = data.nameEn
//
//            Picasso.get()
//                .load(data.flag)
//                .into(flagImg)

        }
    }
}