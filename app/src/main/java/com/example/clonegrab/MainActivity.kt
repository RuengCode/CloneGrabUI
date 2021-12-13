package com.example.clonegrab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.smarteist.autoimageslider.SliderView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecylerView : RecyclerView
    private lateinit var newArrayList : ArrayList<News>
    lateinit var imgFood : Array<Int>
    lateinit var nameFood : Array<String>
    lateinit var priceFood : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSlider = findViewById<SliderView>(R.id.imageSlider)
        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DXXFu.jpg")
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DaZ5a.jpg")
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DaWIN.jpg")
        setImageInSlider(imageList, imageSlider)

        val listFood = findViewById<LinearLayout>(R.id.listFood)

        listFood.setOnClickListener {
            val intent = Intent(this@MainActivity, ListFood::class.java)
            startActivity(intent)
        }

        imgFood = arrayOf(
            R.drawable.food3,
            R.drawable.food1,
            R.drawable.food4,
            R.drawable.food2
        )
        nameFood = arrayOf(
            "asdadsad",
            "sadsadsadsa",
            "asdasdad",
            "sadsads",
            "asd"
        )
        priceFood = arrayOf(
            "50",
            "20",
            "30",
            "10",

        )
        newRecylerView = findViewById(R.id.recycleView2)
        newRecylerView.layoutManager = LinearLayoutManager(this,
        LinearLayoutManager.HORIZONTAL,false)
        newRecylerView.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserdata()

    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {
        val adapter = MySliderImageAdapter()
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }
    private fun getUserdata() {
        for (i in imgFood.indices){
            val news = News(imgFood[i],nameFood[i],priceFood[i])
            newArrayList.add(news)
        }
        newRecylerView.adapter = MyAdapter(newArrayList)
    }
}