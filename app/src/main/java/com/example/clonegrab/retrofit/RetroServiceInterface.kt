package com.example.clonegrab.retrofit

import com.example.clonegrab.data.CoinsModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {
        @GET("prefixes?offset=0&limit=10")

    fun getCoinsList() : Call<List<CoinsModel>>

}