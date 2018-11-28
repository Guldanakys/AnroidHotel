package com.example.guldana.myhotelapplication.main.hotelRooms

import com.example.guldana.myhotelapplication.base.BasePresenter
import com.example.guldana.myhotelapplication.base.BaseView
import com.example.guldana.myhotelapplication.models.HotelRoom

interface RoomsContract {
    interface View : BaseView<Presenter> {
        fun roomsShow(newsList: ArrayList<HotelRoom>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadRooms()
    }
}