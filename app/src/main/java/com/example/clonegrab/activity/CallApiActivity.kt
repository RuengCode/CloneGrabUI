package com.example.clonegrab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.R
import com.example.clonegrab.adapter.UserAdapter
import com.example.clonegrab.data.MyDataItem
import com.example.clonegrab.data.CoinsItem

import com.example.clonegrab.model.UserResponse
import com.example.clonegrab.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_call_api.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallApiActivity : AppCompatActivity() {
    private lateinit var coinsRecyclerView: RecyclerView
    private var list = ArrayList<CoinsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_api)

        show()

    }

    private fun show() {
        coinsRecyclerView = findViewById(R.id.reCallApi)
        coinsRecyclerView.setHasFixedSize(true)
        coinsRecyclerView.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getUsers().enqueue(object : Callback<MyDataItem?> {

            override fun onResponse(call: Call<MyDataItem?>, response: Response<MyDataItem?>) {
                val listResponse = response.body()?.data?.coins
                for(i in 0 until (listResponse!!.size)){
                    val new = listResponse[i]
                    list.add(new!!)
                }
//                listResponse?.let { list.addAll(it) }
                val adapter = UserAdapter(list)

                coinsRecyclerView.adapter = adapter
                Log.d("Main", response.body().toString())
                txView.text = response.code().toString()
                Log.d("Main_count",adapter.itemCount.toString())

                Toast.makeText(this@CallApiActivity, "ผ่านนนน", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<MyDataItem?>, t: Throwable) {
                txView.text = t.message
                Toast.makeText(this@CallApiActivity, "ไม่ผ่านนน", Toast.LENGTH_LONG).show()
            }
        })
    }

}
