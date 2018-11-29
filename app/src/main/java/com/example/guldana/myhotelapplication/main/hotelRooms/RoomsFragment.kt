package com.example.guldana.myhotelapplication.main.hotelRooms

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guldana.myhotelapplication.R
import com.example.guldana.myhotelapplication.main.adapters.RoomsListAdapter
import com.example.guldana.myhotelapplication.models.HotelRoom
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RoomsFragment : Fragment(), RoomsContract.View {

    override val presenter: RoomsContract.Presenter by inject { parametersOf(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rooms, container, false)

        presenter.loadRooms()

        return view
    }

    override fun roomsShow(roomsList: ArrayList<HotelRoom>) {
        val adapter = RoomsListAdapter(roomsList)
        val recyclerView = view!!.findViewById(R.id.recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

}

