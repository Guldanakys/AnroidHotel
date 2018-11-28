package com.example.guldana.myhotelapplication.main.bookings

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.guldana.myhotelapplication.R
import com.example.guldana.myhotelapplication.main.adapters.BookingsListAdapter
import com.example.guldana.myhotelapplication.main.addBooking.AddBookingActivity
import com.example.guldana.myhotelapplication.models.Booking
import kotlinx.android.synthetic.main.fragment_bookings.view.*

class BookingsFragment : Fragment() {

    private val ADD_TASK_REQUEST = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bookings, container, false)

        val bookingsList = ArrayList<Booking>()
        bookingsList.add(Booking("1", "Danny", "President Lux", "05", "07", "2018"))
        bookingsList.add(Booking("2", "Danny", "Standard", "23", "12", "2018"))
        bookingsList.add(Booking("3", "Danny", "President Lux", "05", "07", "2018"))
        val adapter = BookingsListAdapter(bookingsList)
        val recyclerView = view.findViewById(R.id.recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        view.flt_btn_add.setOnClickListener {
            val intent = Intent(activity, AddBookingActivity::class.java)
            startActivityForResult(intent, ADD_TASK_REQUEST)
            bookingsList.clear()
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_TASK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(activity, "Booking completed successfully!", Toast.LENGTH_LONG).show()
            }
        }
    }

}
