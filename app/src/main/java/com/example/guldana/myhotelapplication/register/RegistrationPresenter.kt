package com.example.guldana.myhotelapplication.register

import com.example.guldana.myhotelapplication.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistrationPresenter(override var view: RegistrationContract.View?) :
        RegistrationContract.Presenter {

    val mAuth = FirebaseAuth.getInstance()

    val mDatabase = FirebaseDatabase.getInstance().getReference("users")

    override fun register(email: String, password: String, confirmPassword: String, name: String) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
            if(it.isSuccessful) {
                val current_user = mAuth.currentUser
                val current_uid = current_user!!.uid
                val user = User(current_uid, name)
                mDatabase.child(current_uid).setValue(user)
                view?.onRegisterSuccess()
            } else {
                view?.onRegisterError()
            }
        }
    }
}