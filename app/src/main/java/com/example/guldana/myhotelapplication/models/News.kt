package com.example.guldana.myhotelapplication.models

class News (
        val id: String,
        val title: String,
        val desc: String,
        val imgUrl:String
) {

    constructor() : this("", "", "", "") {

    }
}