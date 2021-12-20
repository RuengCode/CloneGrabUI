package com.example.clonegrab.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clonegrab.data.CoinsModel
import com.example.clonegrab.retrofit.RetroInstance

import com.example.clonegrab.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class CoinsActivityModel : ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<CoinsModel>>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<List<CoinsModel>> {
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getCoinsList()
        call.enqueue(object : Callback<List<CoinsModel>> {
            override fun onFailure(call: Call<List<CoinsModel>>, t: Throwable) {
                liveDataList.postValue(null)
                
            }

            override fun onResponse(
                call: Call<List<CoinsModel>>,
                response: Response<List<CoinsModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }
}

