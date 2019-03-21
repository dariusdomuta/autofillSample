package com.dariusdomuta.autofillsampleapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_success.*

class SuccessActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, SuccessActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                startActivity(SignInActivity.newIntent(this@SuccessActivity))
            }

            override fun onTick(remainingTime: Long) {
                timer.text = (remainingTime / 1000).toInt().toString()
            }
        }.start()
    }
}