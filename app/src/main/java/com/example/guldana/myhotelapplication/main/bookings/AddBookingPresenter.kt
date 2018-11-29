package com.example.guldana.myhotelapplication.main.bookings

import com.example.guldana.myhotelapplication.models.Booking
import com.example.guldana.myhotelapplication.models.HotelRoom
import com.example.guldana.myhotelapplication.models.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AddBookingPresenter(override var view: AddBookingContract.View?) :
        AddBookingContract.Presenter {

    val mDatabaseRooms = FirebaseDatabase.getInstance().getReference("rooms")

    val mDatabaseUsers = FirebaseDatabase.getInstance().getReference("users")

    val mDatabaseBookings = FirebaseDatabase.getInstance().getReference("bookings")

    lateinit var userName : String

    override fun loadForm(userId: String) {

        mDatabaseUsers.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(u in p0.children){
                        val user = u.getValue(User::class.java)
                        if(user!!.id == userId) {
                            userName = user.name
                        }
                    }
                }
            }

        })

        val myOptions = ArrayList<String>()
        mDatabaseRooms.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(n in p0.children){
                        val hotelRoom = n.getValue(HotelRoom::class.java)
                        myOptions.add(hotelRoom!!.title)
                    }
                }
                view?.spinnerShow(myOptions)
            }

        })

    }

    override fun saveBooking(day: String, month: String, year: String, room: String) {
        val booking = Booking("1", userName, room, day, month, year)
        val bId = mDatabaseBookings.push().key!!
        booking.id = bId
        mDatabaseBookings.child(bId).setValue(booking)
    }

}