package com.example.guldana.myhotelapplication.models

class HotelRoom (
        val id: String,
        val title: String,
        val type: String,
        val imgUrl:String,
        val description: String,
        val price: Double
) {

    constructor() : this("", "", "", "", "", 0.00) {

    }
}