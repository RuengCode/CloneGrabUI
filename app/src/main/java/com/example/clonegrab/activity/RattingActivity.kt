package com.example.clonegrab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.clonegrab.R
import com.hsalf.smilerating.SmileRating

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
            startActivity(Intent(this, ShowActivity::class.java)
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