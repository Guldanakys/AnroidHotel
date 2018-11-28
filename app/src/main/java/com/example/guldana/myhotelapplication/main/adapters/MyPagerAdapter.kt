package com.example.guldana.myhotelapplication.main.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.guldana.myhotelapplication.main.bookings.BookingsFragment
import com.example.guldana.myhotelapplication.main.hotelRooms.RoomsFragment
import com.example.guldana.myhotelapplication.main.news.NewsFragment

class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return NewsFragment()
            }
            1 -> {
                return RoomsFragment()
            }
            2 -> {
                return BookingsFragment()
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "News"
            1 -> return "Rooms"
            2 -> return "Bookings"
        }
        return null
    }

}