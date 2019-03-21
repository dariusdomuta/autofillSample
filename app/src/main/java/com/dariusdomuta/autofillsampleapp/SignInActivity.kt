package com.dariusdomuta.autofillsampleapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.autofill.AutofillManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SignInActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginButton.setOnClickListener {
            if (isValidLogin(usernameField.text.toString(), passwordField.text.toString())) {
                startActivity(SuccessActivity.newIntent(this))
                finish()
            } else {
                Toast.makeText(this, "Authentication failed!", Toast.LENGTH_LONG).show()
            }
        }

        registerButton.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

    }

    private fun isValidLogin(username: String?, password: String?) : Boolean {
        return !username.isNullOrEmpty() && !password.isNullOrEmpty()
    }
}
