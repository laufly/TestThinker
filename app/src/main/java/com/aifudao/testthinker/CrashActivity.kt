package com.aifudao.testthinker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crash.*

    class CrashActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_crash)
            crashBtn.setOnClickListener {
                100/100
            }
        }
    }
