package com.example.clonegrab.activity

import android.content.Intent
import android.icu.number.NumberFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.clonegrab.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class DetailViewActivity : AppCompatActivity() {
    lateinit var nametxt : TextView
    lateinit var imageMain : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)

        nametxt = findViewById(R.id.txtNameMain)
        imageMain = findViewById(R.id.imageViewMain)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("url")

        nametxt.text = name

        Picasso.get()
            .load(image)
            .into(imageMain)
    }
}