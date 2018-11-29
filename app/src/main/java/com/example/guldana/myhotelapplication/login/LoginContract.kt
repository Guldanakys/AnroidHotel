package com.example.guldana.myhotelapplication.login

import com.example.guldana.myhotelapplication.base.BasePresenter
import com.example.guldana.myhotelapplication.base.BaseView
import com.google.firebase.auth.FirebaseUser

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun onLogSuccess(user: FirebaseUser)
        fun onLogError()
    }

    interface Presenter : BasePresenter<View> {
        fun login(email: String, password: String)
    }
}