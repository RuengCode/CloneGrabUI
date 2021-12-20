package com.example.clonegrab.data

import com.example.clonegrab.test.*
import com.google.gson.annotations.SerializedName

data class CoinsModel(


    @field:SerializedName("name_th")
    val nameTh: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name_en")
    val nameEn: String? = null
)

