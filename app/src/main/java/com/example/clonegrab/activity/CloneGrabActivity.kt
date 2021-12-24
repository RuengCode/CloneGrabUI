package com.example.clonegrab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.clonegrab.*
import kotlinx.android.synthetic.main.activity_main.*

class CloneGrabActivity : AppCompatActivity() {

    private val testFragment = TestFragment()
    private val readJsonFragment = ReadJsonFragment()
    private val callApiFragment = CallApiFragment()
    private val sqliteFragment = SqliteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clone_grab)


        replaceFragment(testFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> replaceFragment(testFragment)
                R.id.page_2 -> replaceFragment(readJsonFragment)
                R.id.page_3 -> replaceFragment(callApiFragment)
                R.id.page_4 -> replaceFragment(sqliteFragment)

            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()

        }
    }
}