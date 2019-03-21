package com.dariusdomuta.autofillsampleapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.register_screen_email.*

class RegisterUsernameFragment: Fragment() {

    companion object {
        fun newInstance():Fragment {
            return RegisterUsernameFragment()
        }
    }

    lateinit var registrationNavigation: RegistrationNavigation

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        registrationNavigation = context as RegistrationNavigation
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.register_screen_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerNextScreen.setOnClickListener {
            if (validateUsername(registerUsername.text.toString())) {
                registrationNavigation.showPasswordRegistration()
            } else {
                Toast.makeText(context, "Invalid Username!", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun validateUsername(Username: String?): Boolean {
        return !Username.isNullOrEmpty()
    }
}