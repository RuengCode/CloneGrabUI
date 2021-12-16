package com.example.clonegrab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.clonegrab.R
import com.example.clonegrab.adapter.MySliderImageAdapter
import com.smarteist.autoimageslider.SliderView

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

    fun rattingStar(item: android.view.MenuItem) {
        val intent = Intent(this, RattingActivity::class.java)
        startActivity(intent)
    }

    fun listData(item: android.view.MenuItem) {
        val intent = Intent(this, ApiActivity::class.java)
        startActivity(intent)
    }

    fun dataBase(item: android.view.MenuItem) {
        val intent = Intent(this, SqliteActivity::class.java)
        startActivity(intent)
    }


}