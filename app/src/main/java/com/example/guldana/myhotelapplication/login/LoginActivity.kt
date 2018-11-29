package com.example.guldana.myhotelapplication.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guldana.myhotelapplication.main.MainActivity
import com.example.guldana.myhotelapplication.R
import com.example.guldana.myhotelapplication.register.RegistrationActivity
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginContract.View  {

    override val presenter: LoginContract.Presenter by inject { parametersOf(this) }

    var currentUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val email = edx_email.text.toString()
            val password = edx_password.text.toString()
            if(!email.isEmpty() && !password.isEmpty()) {
                presenter.login(email, password)
            } else {
                Toast.makeText(this, "Please fill up the credentials!", Toast.LENGTH_LONG).show()
            }
        }

        txt_registration.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    override fun onLogSuccess(user: FirebaseUser) {
        currentUser = user
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("userId", user.uid)
        startActivity(intent)
        finish()
    }

    override fun onLogError() {
        Toast.makeText(this, "Error, please check the credentials or internet connection!", Toast.LENGTH_LONG).show()
    }
}
