package com.example.clonegrab

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RatingBar
import com.hsalf.smilerating.BaseRating.GREAT
import com.hsalf.smilerating.SmileRating
import com.hsalf.smileyrating.SmileyRating
import com.hsalf.smileyrating.smileys.Good

class RattingActivity : AppCompatActivity() {
    private var numStar = 0
    private lateinit var editTxtName : EditText
    private lateinit var editTxtDetail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratting)


        val btn = findViewById<Button>(R.id.btnScore)

        btn.setOnClickListener{
            editTxtName = findViewById(R.id.inputName)
            editTxtDetail = findViewById(R.id.inputDetail)
            startActivity(Intent(this,ShowActivity::class.java)
                .putExtra("user",editTxtName.text.toString())
                .putExtra("detail",editTxtDetail.text.toString()))

    }
    fun onSmileySelected(smileyRating: Int){
            when(smileyRating) {
                SmileRating.GREAT -> numStar = 5
                SmileRating.GOOD -> numStar = 4
                SmileRating.OKAY -> numStar = 3
                SmileRating.BAD -> numStar = 2
                SmileRating.TERRIBLE -> numStar = 1
            }
            Log.d("Star",numStar.toString())
        }
    }





}