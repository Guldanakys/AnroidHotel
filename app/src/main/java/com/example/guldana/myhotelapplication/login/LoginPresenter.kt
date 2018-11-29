package com.example.guldana.myhotelapplication.login

import com.google.firebase.auth.FirebaseAuth

class LoginPresenter(override var view: LoginContract.View?) :
        LoginContract.Presenter {

    val mAuth = FirebaseAuth.getInstance()

    override fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val currentUser = mAuth.currentUser
                if (currentUser != null)
                    view?.onLogSuccess(currentUser)
                else
                    view?.onLogError()
            } else {
                view?.onLogError()
            }
        }
    }
}