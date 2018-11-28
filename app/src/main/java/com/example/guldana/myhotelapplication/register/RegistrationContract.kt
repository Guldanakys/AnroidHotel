package com.example.guldana.myhotelapplication.register

import com.example.guldana.myhotelapplication.base.BasePresenter
import com.example.guldana.myhotelapplication.base.BaseView

interface RegistrationContract {
    interface View : BaseView<Presenter> {
        fun onRegisterSuccess()
        fun onRegisterError()
    }

    interface Presenter : BasePresenter<View> {
        fun register(email: String, password: String, confirmPassword: String, name: String)
    }
}