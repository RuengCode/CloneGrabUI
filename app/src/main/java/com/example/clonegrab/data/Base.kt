package com.example.clonegrab.data


import com.google.gson.annotations.SerializedName

data class Base(
    @SerializedName("sign")
    val sign: String,
    @SerializedName("symbol")
    val symbol: String
)