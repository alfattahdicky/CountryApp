package com.example.countryapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val btnStarted: Button = findViewById(R.id.btn_started)
        btnStarted.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val moveIntent = Intent(this, MainActivity::class.java)
        startActivity(moveIntent)
    }
}