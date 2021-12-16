package com.example.clonegrab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.R
import com.example.clonegrab.model.DataModel


class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    private var dataList : ArrayList<DataModel> = ArrayList()
    private var onClickItem: ((DataModel) -> Unit?)? = null

    fun addItem(items : ArrayList<DataModel>){
        this.dataList = items
        notifyDataSetChanged()
    }
    fun setOnClickItem(callback : (DataModel) -> Unit){
        this.onClickItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_item_data,parent,false)
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindView(data)
        holder.itemView.setOnClickListener{
            onClickItem?.invoke(data)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class DataViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        private var id = view.findViewById<TextView>(R.id.tvId)
        private var name = view.findViewById<TextView>(R.id.tvName)
        private var game = view.findViewById<TextView>(R.id.tvGame)
        private var email = view.findViewById<TextView>(R.id.tvEnail)
        private var btnDelete = view.findViewById<Button>(R.id.btnDelete)

        fun bindView(data:DataModel){
            id.text = data.id.toString()
            name.text = data.name
            game.text = data.game
            email.text = data.email
        }

    }
}