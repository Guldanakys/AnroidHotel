package com.example.guldana.myhotelapplication.main.bookings

import com.example.guldana.myhotelapplication.base.BasePresenter
import com.example.guldana.myhotelapplication.base.BaseView
import com.example.guldana.myhotelapplication.models.Booking

interface AddBookingContract {
    interface View : BaseView<Presenter> {
        fun spinnerShow(optionsList: ArrayList<String>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadForm(userId: String)
        fun saveBooking(day: String, month: String, year: String, room: String)
    }
}