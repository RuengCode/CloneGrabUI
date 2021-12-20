package com.example.clonegrab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.R
import com.example.clonegrab.adapter.CoinsAdapter
import com.example.clonegrab.model.CoinsActivityModel

class CallApiActivity : AppCompatActivity() {
    private lateinit var coinsRecyclerViwe : RecyclerView
    private lateinit var recyclerAdapter : CoinsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_api)

        initRecyclerView()
        initViewModel()
    }
    private fun initRecyclerView(){
        coinsRecyclerViwe = findViewById(R.id.reCallApi)
        coinsRecyclerViwe.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CoinsAdapter(this)
        coinsRecyclerViwe.adapter = recyclerAdapter


    }
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(CoinsActivityModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){
                recyclerAdapter.setCoins(it)
                recyclerAdapter.notifyDataSetChanged()
                Log.d("Main",recyclerAdapter.itemCount.toString())
            }else{
                Toast.makeText(this,"ไม่มีอะไรเลยจ้า",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }
}