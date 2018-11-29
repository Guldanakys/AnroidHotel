package com.example.guldana.myhotelapplication.main.bookings


import com.example.guldana.myhotelapplication.models.Booking
import com.example.guldana.myhotelapplication.models.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BookingsPresenter(override var view: BookingsContract.View?) :
        BookingsContract.Presenter {

    val mDatabaseBookings = FirebaseDatabase.getInstance().getReference("bookings")

    val mDatabaseUsers = FirebaseDatabase.getInstance().getReference("users")

    lateinit var userName : String

    override fun loadBookings(userId: String) {

        mDatabaseUsers.addValueEventListener(object: ValueEventListener{
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

        val bookingsList = ArrayList<Booking>()
        mDatabaseBookings.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(b in p0.children){
                        val booking = b.getValue(Booking::class.java)
                        if(userName == booking!!.userName) {
                            bookingsList.add(booking)
                        }
                    }
                }
                view?.bookingsShow(bookingsList)
            }
        })

    }

}