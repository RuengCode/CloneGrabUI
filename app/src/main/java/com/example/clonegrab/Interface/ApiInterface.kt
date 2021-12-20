package com.example.clonegrab.Interface


import com.example.clonegrab.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("albums")
    fun getData(): Call<UserResponse>
}