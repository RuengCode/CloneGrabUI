package com.example.clonegrab.activity

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.Interface.ApiInterface
import com.example.clonegrab.R
import com.example.clonegrab.adapter.MyAdapter
import com.example.clonegrab.data.MyDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recycleviewUser: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        recycleviewUser = findViewById(R.id.recycleViewUser)
        recycleviewUser.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(this)
        recycleviewUser.layoutManager = linearLayoutManager
        getMydata()
    }

    private fun getMydata() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!
                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recycleviewUser = findViewById(R.id.recycleViewUser)
                recycleviewUser.adapter = myAdapter

                Log.d("Main_itemCount", myAdapter.itemCount.toString())

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d(TAG, "Main" + t.message)
            }
        })

    }

}