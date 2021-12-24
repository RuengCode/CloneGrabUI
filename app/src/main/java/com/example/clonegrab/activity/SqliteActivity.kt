package com.example.clonegrab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.R
import com.example.clonegrab.adapter.DataAdapter
import com.example.clonegrab.database.SQLiteHelper
import com.example.clonegrab.model.DataModel

class SqliteActivity : AppCompatActivity() {
    private lateinit var edName : EditText
    private lateinit var edGame : EditText
    private lateinit var edEmail : EditText
    private lateinit var btnAdd : Button
    private lateinit var btnView : Button
    private lateinit var btnUpdate : Button
    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter:DataAdapter? = null
    private var data:DataModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        initView()
        initRecycleView()
        sqLiteHelper = SQLiteHelper(this)
        btnAdd.setOnClickListener{addData()}
        btnView.setOnClickListener{getData()}
        btnUpdate.setOnClickListener{updateData()}
        adapter?.setOnClickItem{
            Toast.makeText(this,it.name,Toast.LENGTH_SHORT).show()
            edName.setText(it.name)
            edGame.setText(it.game)
            edEmail.setText(it.email)
            data = it
        }
        adapter?.setOnClickDeleteItem {

        }
    }

    private fun updateData() {
        val name = edName.text.toString()
        val game = edGame.text.toString()
        val email = edEmail.text.toString()

        if (name == data?.name && game ==data?.game && email == data?.email){
            Toast.makeText(this,"ไม่เปลี่ยนแปลง",Toast.LENGTH_SHORT).show()
            return
        }
        if (data == null) return

        val data = DataModel(id = data!!.id,name = name , game = game ,email = email)
        val status = sqLiteHelper.updateData(data)
        if (status > -1){
            Toast.makeText(this,"Update เรียบร้อยละจ้า",Toast.LENGTH_SHORT).show()
            clearEditText()
            getData()
        }else{
            Toast.makeText(this,"Update ผิดพลาดนะจ๊ะ",Toast.LENGTH_SHORT).show()
        }


    }

    private fun getData() {
        val dataList = sqLiteHelper.getAllData()
        Log.d("Main_data","${dataList.size}")

        adapter?.addItem(dataList)
    }

    private fun addData() {
        val name = edName.text.toString()
        val game = edGame.text.toString()
        val email = edEmail.text.toString()

        if (name.isEmpty() || game.isEmpty() || email.isEmpty()){

            Toast.makeText(this,"กรอกหน่อยนะ",Toast.LENGTH_SHORT).show()
        }else{
            val data = DataModel(name = name , game = game ,email = email)
            val addData = sqLiteHelper.insertData(data)
            if (addData > -1){
                clearEditText()
                getData()
                Toast.makeText(this,"ดีมากจ้า",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"สู้ๆนะ",Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun clearEditText(){
        edName.setText("")
        edGame.setText("")
        edEmail.setText("")

    }
    private fun deleteData(id : Int){

    }
    private fun initRecycleView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DataAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView(){
        edName = findViewById(R.id.inputName1)
        edGame = findViewById(R.id.inputGame1)
        edEmail= findViewById(R.id.inputEmail1)
        btnAdd= findViewById(R.id.btnInsert)
        btnView = findViewById(R.id.btnView)
        btnUpdate = findViewById(R.id.btnUpdate)
        recyclerView = findViewById(R.id.recycleAddData)

    }
}