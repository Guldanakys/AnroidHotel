package com.example.guldana.myhotelapplication.main.bookings

import com.example.guldana.myhotelapplication.base.BasePresenter
import com.example.guldana.myhotelapplication.base.BaseView
import com.example.guldana.myhotelapplication.models.Booking
import com.example.guldana.myhotelapplication.models.User

interface BookingsContract {
    interface View : BaseView<Presenter> {
        fun bookingsShow(bookingsList: ArrayList<Booking>)
        fun startAddBooking(userId: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadBookings(userId: String)
    }
}