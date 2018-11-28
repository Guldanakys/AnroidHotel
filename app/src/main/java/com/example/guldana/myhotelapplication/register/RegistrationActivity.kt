package com.example.guldana.myhotelapplication.register

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guldana.myhotelapplication.main.MainActivity
import com.example.guldana.myhotelapplication.R
import kotlinx.android.synthetic.main.activity_registration.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RegistrationActivity : AppCompatActivity(), RegistrationContract.View {


    override val presenter: RegistrationContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btn_register.setOnClickListener {
            var email = edx_email.text.toString()
            var password = edx_password.text.toString()
            var confirmPassword = edx_confirm_password.text.toString()
            var name = edx_name.text.toString()
            if(!email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty() && !name.isEmpty()) {
                if(password.equals(confirmPassword)) {
                    presenter.register(email, password, confirmPassword, name)
                } else {
                    Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please fill up the credentials!", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onRegisterSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        Toast.makeText(this, "Successfully signed in!", Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onRegisterError() {
        Toast.makeText(this, "Error, please check the credentials or internet connection!", Toast.LENGTH_LONG).show()
    }
}
