package com.example.clonegrab.Interface

import com.example.clonegrab.data.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    fun getData(): Call<List<MyDataItem>>
}