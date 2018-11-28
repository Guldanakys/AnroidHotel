package com.example.guldana.myhotelapplication.models

class Booking (
        var id: String,
        val userName: String,
        val roomTitle: String,
        val dayOfMonth: String,
        val monthOfYear: String,
        val year: String
) {

    constructor() : this("", "", "", "", "", "") {

    }
}