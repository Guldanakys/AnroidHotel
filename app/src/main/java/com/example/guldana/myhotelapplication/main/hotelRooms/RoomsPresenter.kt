package com.example.guldana.myhotelapplication.main.hotelRooms

import com.example.guldana.myhotelapplication.models.HotelRoom
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RoomsPresenter(override var view: RoomsContract.View?) :
        RoomsContract.Presenter {

    val mDatabase = FirebaseDatabase.getInstance().getReference("rooms")

    override fun loadRooms() {
        val roomsList = ArrayList<HotelRoom>()
        mDatabase.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(r in p0.children){
                        val room = r.getValue(HotelRoom::class.java)
                        roomsList.add(room!!)
                    }
                }
                view?.roomsShow(roomsList)
            }
        })

    }

}