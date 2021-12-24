package com.example.clonegrab.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.clonegrab.R

class ShowActivity : AppCompatActivity() {
    private lateinit var imageCoin: ImageView
    private lateinit var txtMainName: TextView
    private lateinit var txtName: TextView
    private lateinit var txtType: TextView
    private lateinit var txtId: TextView
    private lateinit var txtPrice: TextView
    private lateinit var txtRank: TextView
    private lateinit var txtDesc: TextView
    private lateinit var txtColor: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val image = intent.getStringExtra("image")
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val type = intent.getStringExtra("type")
        val price = intent.getStringExtra("price")
        val rank = intent.getStringExtra("rank")
        val desc = intent.getStringExtra("description")
        val color = intent.getStringExtra("color")

        txtColor = findViewById(R.id.colorCoin)
        imageCoin = findViewById(R.id.imgCoin)
        txtMainName = findViewById(R.id.txtMainName)
        txtId = findViewById(R.id.idCoin)
        txtName = findViewById(R.id.nameCoin)
        txtType = findViewById(R.id.typeCoin)
        txtPrice = findViewById(R.id.idPrice)
        txtRank = findViewById(R.id.rankCoin)
        txtDesc = findViewById(R.id.descriptionCoin)
        txtMainName.text = name
        txtId.text = id
        txtName.text = name
        txtType.text = type
        txtPrice.text = price
        txtRank.text = rank
        txtDesc.text = desc
        txtColor.setBackgroundColor(Color.parseColor(color))
        imageCoin.loadSvg(image.toString())

    }

    private fun ImageView.loadSvg(url: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
            .build()

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)
    }
}
