package com.example.clonegrab.Interface

import com.example.clonegrab.data.MyDataItem
import com.example.clonegrab.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("v1/public/coins")

    fun getUsers(): Call<MyDataItem>
}