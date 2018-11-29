package com.example.guldana.myhotelapplication.main.bookings

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guldana.myhotelapplication.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_booking.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AddBookingActivity : AppCompatActivity(), AddBookingContract.View {

    override val presenter: AddBookingContract.Presenter by inject { parametersOf(this) }

    lateinit var userId : String
    lateinit var bDay : String
    lateinit var bMonth : String
    lateinit var bYear : String
    lateinit var bRoom: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_booking)

        userId = intent.getStringExtra("userId")

        presenter.loadForm(userId)

        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val msg = "" + dayOfMonth + "/" + (month + 1) + "/" + year
            txt_date.text = msg
            bDay = dayOfMonth.toString()
            bMonth = (month + 1).toString()
            bYear = year.toString()
        }

        btn_save_booking.setOnClickListener {
            presenter.saveBooking(bDay, bMonth, bYear, bRoom)
            val result = Intent()
            setResult(Activity.RESULT_OK, result)
            finish()
        }

    }


    override fun spinnerShow(optionsList: ArrayList<String>) {
        val spAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsList)
        spAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        my_spinner.adapter = spAdapter
        my_spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                 bRoom = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>){

            }
        }
    }
}
