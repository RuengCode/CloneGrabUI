package com.example.clonegrab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.clonegrab.activity.Test1Activity
import com.example.clonegrab.adapter.MySliderImageAdapter
import com.smarteist.autoimageslider.SliderView

class TestFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val view =  inflater.inflate(R.layout.fragment_test, container, false)
        val listFood = view.findViewById<LinearLayout>(R.id.listFood)

        val imageSlider = view.findViewById<SliderView>(R.id.imageSlider)

        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DXXFu.jpg")
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DaZ5a.jpg")
        imageList.add("https://sv1.picz.in.th/images/2021/12/09/6DaWIN.jpg")
        setImageInSlider(imageList, imageSlider)

        listFood.setOnClickListener {
            val intent = Intent(context, Test1Activity::class.java)
            startActivity(intent)
        }
        return view
    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {
        val adapter = MySliderImageAdapter()
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }

}