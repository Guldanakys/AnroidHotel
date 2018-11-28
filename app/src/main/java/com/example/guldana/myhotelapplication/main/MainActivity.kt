package com.example.guldana.myhotelapplication.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guldana.myhotelapplication.R
import com.example.guldana.myhotelapplication.main.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)

    }

}