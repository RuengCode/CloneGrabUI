package com.example.clonegrab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.adapter.DataAdapter
import com.example.clonegrab.database.SQLiteHelper
import com.example.clonegrab.model.DataModel

class SqliteFragment : Fragment() {
    private lateinit var edName: EditText
    private lateinit var edGame: EditText
    private lateinit var edEmail: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button
    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter: DataAdapter? = null
    private var data: DataModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sqlite, container, false)
        initView(view)
        initRecycleView()
        sqLiteHelper = SQLiteHelper(requireContext())
        btnAdd.setOnClickListener { addData() }
        btnView.setOnClickListener { getData() }
        btnUpdate.setOnClickListener { updateData() }
        adapter?.setOnClickItem {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            edName.setText(it.name)
            edGame.setText(it.game)
            edEmail.setText(it.email)
            data = it
        }
        return view
    }
  ;

    private fun updateData() {
        val name = edName.text.toString()
        val game = edGame.text.toString()
        val email = edEmail.text.toString()

        if (name == data?.name && game == data?.game && email == data?.email) {
            Toast.makeText(context, "ไม่เปลี่ยนแปลง", Toast.LENGTH_SHORT).show()
            return
        }
        if (data == null) return

        val data = DataModel(id = data!!.id, name = name, game = game, email = email)
        val status = sqLiteHelper.updateData(data)
        if (status > -1) {
            Toast.makeText(context, "Update เรียบร้อยละจ้า", Toast.LENGTH_SHORT).show()
            clearEditText()
            getData()
        } else {
            Toast.makeText(context, "Update ผิดพลาดนะจ๊ะ", Toast.LENGTH_SHORT).show()
        }


    }

    private fun getData() {
        val dataList = sqLiteHelper.getAllData()
        Log.d("Main_data", "${dataList.size}")

        adapter?.addItem(dataList)
    }

    private fun addData() {
        val name = edName.text.toString()
        val game = edGame.text.toString()
        val email = edEmail.text.toString()

        if (name.isEmpty() || game.isEmpty() || email.isEmpty()) {

            Toast.makeText(context, "กรอกหน่อยนะ", Toast.LENGTH_SHORT).show()
        } else {
            val data = DataModel(name = name, game = game, email = email)
            val addData = sqLiteHelper.insertData(data)
            if (addData > -1) {
                clearEditText()
                getData()
                Toast.makeText(context, "ดีมากจ้า", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "สู้ๆนะ", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun clearEditText() {
        edName.setText("")
        edGame.setText("")
        edEmail.setText("")

    }

    private fun initRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = DataAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView(view: View) {
        edName = view.findViewById(R.id.inputName1)
        edGame = view.findViewById(R.id.inputGame1)
        edEmail = view.findViewById(R.id.inputEmail1)
        btnAdd = view.findViewById(R.id.btnInsert)
        btnView = view.findViewById(R.id.btnView)
        btnUpdate = view.findViewById(R.id.btnUpdate)
        recyclerView = view.findViewById(R.id.recycleAddData)

    }


}