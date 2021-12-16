package com.example.clonegrab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.clonegrab.R

class ShowActivity : AppCompatActivity() {
    private lateinit var txtUsername : TextView
    private lateinit var txtDetail : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        txtUsername = findViewById(R.id.txtUsername)
        txtDetail = findViewById(R.id.txtDetail)

        val userName = intent.getStringExtra("user")
        val deTail = intent.getStringExtra("detail")

        txtUsername.text= "ผู้ใช้ : " + userName
        txtDetail.text = "รายละเอียด : " + deTail
    }
}