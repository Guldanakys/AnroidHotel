package com.example.guldana.myhotelapplication.base

interface BaseView<out P : BasePresenter<*>> {
    val presenter: P
}