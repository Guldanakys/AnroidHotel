package com.example.guldana.myhotelapplication.main.bookings

import android.app.Activity
import android.content.Intent
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
import com.example.guldana.myhotelapplication.models.Booking
import kotlinx.android.synthetic.main.fragment_bookings.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class BookingsFragment : Fragment(), BookingsContract.View {

    override val presenter: BookingsContract.Presenter by inject { parametersOf(this) }

    lateinit var userId : String

    private val ADD_TASK_REQUEST = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bookings, container, false)

        userId = activity!!.intent.getStringExtra("userId")

        presenter.loadBookings(userId)

        view.flt_btn_add.setOnClickListener {
            startAddBooking(userId)
        }

        return view
    }

    override fun bookingsShow(bookingsList: ArrayList<Booking>) {
        val adapter = BookingsListAdapter(bookingsList)
        val recyclerView = view!!.findViewById(R.id.recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun startAddBooking(userId: String) {
        val intent = Intent(activity, AddBookingActivity::class.java)
        intent.putExtra("userId", userId)
        startActivityForResult(intent, ADD_TASK_REQUEST)
        //startActivity(intent)
        Toast.makeText(activity, userId, Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_TASK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(activity, "Booking completed successfully!", Toast.LENGTH_LONG).show()
            }
        }
    }

}
