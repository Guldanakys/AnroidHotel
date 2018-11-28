package com.example.guldana.myhotelapplication.login

import com.example.guldana.myhotelapplication.base.BasePresenter
import com.example.guldana.myhotelapplication.base.BaseView

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun onLogSuccess()
        fun onLogError()
    }

    interface Presenter : BasePresenter<View> {
        fun login(email: String, password: String)
    }
}