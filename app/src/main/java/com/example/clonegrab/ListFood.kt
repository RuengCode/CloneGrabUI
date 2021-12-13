package com.example.clonegrab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFood : AppCompatActivity() {

    private lateinit var newRecylerView : RecyclerView
    private lateinit var newArrayList : ArrayList<News>
    lateinit var imgFood : Array<Int>
    lateinit var nameFood : Array<String>
    lateinit var priceFood : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        imgFood = arrayOf(
            R.drawable.food3,
            R.drawable.food1,
            R.drawable.food4,
            R.drawable.food2,
            R.drawable.water3
        )
        nameFood = arrayOf(
            "ข้าวหรือป่าว",
            "ข้าวป่าวหรือ",
            "หรือข้าวป่าว",
            "ข้าวป่าวๆ",
            "ข้าวหรือข้าวป่าว"

        )
        priceFood = arrayOf(
            "50",
            "20",
            "30",
            "10",
            "15"
        )
        newRecylerView = findViewById(R.id.recyclerView)
        newRecylerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        newRecylerView.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserdata()


    }

    private fun getUserdata() {
        for (i in imgFood.indices){
            val news = News(imgFood[i],nameFood[i],priceFood[i])
            newArrayList.add(news)
        }
        newRecylerView.adapter = MyAdapter(newArrayList)
    }
}