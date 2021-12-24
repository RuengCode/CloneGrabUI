package com.example.clonegrab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clonegrab.adapter.UserAdapter1
import com.example.clonegrab.model.UserModelClass1
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class ReadJsonFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val view = inflater.inflate(R.layout.fragment_read_json, container, false)
        val usersList: ArrayList<UserModelClass1> = ArrayList()

        try {

            val obj = JSONObject(getJSONFromAssets()!!)

            val usersArray = obj.getJSONArray("data")

            for (i in 0 until usersArray.length()) {

                val user = usersArray.getJSONObject(i)

                val image = user.getString("image")
                val name = user.getString("name")
                val price = user.getInt("price")
                val description = user.getString("description")

                val userDetails =
                    UserModelClass1(price, name, description, image)

                usersList.add(userDetails)
            }
        } catch (e: JSONException) {

            e.printStackTrace()
        }

        val rvUsersList = view?.findViewById<RecyclerView>(R.id.rvUsersList)
        rvUsersList?.layoutManager = LinearLayoutManager(this.context)

        val itemAdapter = UserAdapter1(requireContext(), usersList)

        rvUsersList?.adapter = itemAdapter
        Log.d("main", itemAdapter.itemCount.toString())


        return view
    }

    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = resources.openRawResource(R.raw.json_test2)
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}