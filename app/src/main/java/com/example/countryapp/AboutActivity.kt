package com.example.countryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnBack: ImageButton = findViewById(R.id.btn_back)
        val textToolbar: TextView = findViewById(R.id.text_toolbar)
        val textAnotherToolbar: TextView = findViewById(R.id.text_another_toolbar)
        val btnAbout: ImageButton = findViewById(R.id.btn_about)

        btnBack.visibility = View.VISIBLE
        textToolbar.visibility = View.GONE
        textAnotherToolbar.visibility = View.VISIBLE
        btnAbout.visibility = View.GONE

        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val backMain = Intent(this, MainActivity::class.java)
        startActivity(backMain)
        finish()
    }
}