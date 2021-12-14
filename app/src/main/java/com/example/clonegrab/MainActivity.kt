package com.example.clonegrab

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.adapter.MySliderImageAdapter
import com.google.gson.Gson
import com.smarteist.autoimageslider.SliderView
import java.io.InputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFood = findViewById<LinearLayout>(R.id.listFood)

        val imageSlider = findViewById<SliderView>(R.id.imageSlider)

        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DXXFu.jpg")
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DaZ5a.jpg")
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DaWIN.jpg")
        setImageInSlider(imageList, imageSlider)

        listFood.setOnClickListener {
            val intent = Intent(this, Test1Activity::class.java)
            startActivity(intent)
        }

    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {
        val adapter = MySliderImageAdapter()
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }


}