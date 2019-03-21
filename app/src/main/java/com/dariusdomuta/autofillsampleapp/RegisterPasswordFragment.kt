package com.dariusdomuta.autofillsampleapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.autofill.AutofillManager
import kotlinx.android.synthetic.main.register_screen_email.*
import kotlinx.android.synthetic.main.register_screen_password.*

class RegisterPasswordFragment : Fragment() {

    companion object {
        fun newInstance():Fragment {
            return RegisterPasswordFragment()
        }
    }
    lateinit var registrationNavigation: RegistrationNavigation
    var autofillManager: AutofillManager? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        registrationNavigation = context as RegistrationNavigation
        autofillManager = context.getSystemService(AutofillManager::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.register_screen_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerButton.setOnClickListener {
            if (validatePassword(registerPassword.text.toString())) {

                startActivity(SignInActivity.newIntent(context!!))
                if (autofillManager != null) {
                    autofillManager?.commit()
                }

                activity?.finish()
            }
        }

    }

    private fun validatePassword(password: String?): Boolean {
        return !password.isNullOrEmpty()
    }

    override fun onStop() {
        super.onStop()
    }
}