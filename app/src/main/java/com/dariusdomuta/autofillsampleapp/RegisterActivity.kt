package com.dariusdomuta.autofillsampleapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.autofill.AutofillManager

interface RegistrationNavigation {
    fun showUsernameRegistration()

    fun showPasswordRegistration()
}

class RegisterActivity : AppCompatActivity(), RegistrationNavigation {

    lateinit var autofillManager : AutofillManager
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        showUsernameRegistration()
        autofillManager = this.getSystemService(AutofillManager::class.java)
    }

    override fun showUsernameRegistration() {
        replaceFragment(R.id.mainContainer, RegisterUsernameFragment.newInstance())
    }

    override fun showPasswordRegistration() {
        replaceFragment(R.id.mainContainer, RegisterPasswordFragment.newInstance())
    }

    override fun onStop() {
        super.onStop()
        autofillManager.commit()
    }
}