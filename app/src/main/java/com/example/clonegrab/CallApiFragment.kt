package com.example.clonegrab

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.activity.ShowActivity
import com.example.clonegrab.activity.Test1Activity
import com.example.clonegrab.adapter.UserAdapter
import com.example.clonegrab.data.CoinsItem
import com.example.clonegrab.data.MyDataItem
import com.example.clonegrab.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_call_api.*
import kotlinx.android.synthetic.main.coins_list_row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private var list = ArrayList<CoinsItem>()

class CallApiFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_call_api, container, false)
        show(view)
        return view
    }

    private fun show(view: View) {

        val coinsRecyclerView = view.findViewById<RecyclerView>(R.id.reCallApi1)
        coinsRecyclerView.setHasFixedSize(true)
        coinsRecyclerView.layoutManager = LinearLayoutManager(this.context)

        RetrofitClient.instance.getUsers().enqueue(object : Callback<MyDataItem?> {

            override fun onResponse(call: Call<MyDataItem?>, response: Response<MyDataItem?>) {
                list = arrayListOf()
                val listResponse = response.body()?.data?.coins
                for (i in 0 until (listResponse!!.size)) {
                    val new = listResponse[i]
                    list.add(new!!)
                }
                list.sortBy {
                    it.id
                }

//                listResponse?.let { list.addAll(it) }
                val adapter = UserAdapter(list)

                adapter.setOnItemClickListener(object : UserAdapter.onItemClickListener {

                    override fun onItemClick(position: Int) {
                        val image = list[position].iconUrl
                        val id = list[position].id.toString()
                        val name = list[position].name
                        val type = list[position].type
                        val price = list[position].price
                        val color = list[position].color
                        val rank = list[position].rank.toString()
                        val description = list[position].description


                        val intent = Intent(context, ShowActivity::class.java)
                        intent.putExtra("image", image.toString())
                        intent.putExtra("id", id)
                        intent.putExtra("name", name)
                        intent.putExtra("type", type)
                        intent.putExtra("price", price)
                        intent.putExtra("rank", rank)
                        intent.putExtra("color", color)
                        intent.putExtra("description", description)
                        startActivity(intent)

                    }

                })
                coinsRecyclerView.adapter = adapter

                Toast.makeText(context,
                    "โหลดข้อมูลสำเร็จ" + " Code : " + response.code()
                        .toString() + " Item :" + adapter.itemCount.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onFailure(call: Call<MyDataItem?>, t: Throwable) {
                txView.text = t.message
                Toast.makeText(context, "โหลดข้อมูลไม่สำเร็จ", Toast.LENGTH_LONG).show()
            }
        })
    }


}