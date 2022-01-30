package com.example.countryapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btnBack: ImageButton = findViewById(R.id.btn_back)
        val textToolbar: TextView = findViewById(R.id.text_toolbar)
        val textAnotherToolbar: TextView = findViewById(R.id.text_another_toolbar)
        val btnAbout: ImageButton = findViewById(R.id.btn_about)
        val imgPhoto: ImageView = findViewById(R.id.tv_flag)
        val detailText: TextView = findViewById(R.id.description_flag)
        val capitalText: TextView = findViewById(R.id.capital_city)
        val languageText: TextView = findViewById(R.id.national_language)
        val independenceText : TextView = findViewById(R.id.independence_day)
        val wideRegionText: TextView = findViewById(R.id.wide_region)


        val bundle: Bundle?= intent.extras
        val name = bundle!!.getString("name")
        val imageId = bundle.getInt("image")
        val detail = bundle.getString("detail")
        val capitalCity = bundle.getString("capital")
        val nationalLanguage = bundle.getString("language")
        val independenceDay = bundle.getString("independence")
        val wideRegion = bundle.getString("wideRegion")

        btnBack.visibility = View.VISIBLE
        textToolbar.visibility = View.GONE
        textAnotherToolbar.visibility = View.VISIBLE
        btnAbout.visibility = View.GONE

        textAnotherToolbar.text = "$name Country"
        detailText.text = detail
        imgPhoto.setImageResource(imageId)
        capitalText.text = capitalCity
        languageText.text = nationalLanguage
        independenceText.text = independenceDay
        wideRegionText.text = wideRegion

        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val backMain = Intent(this, MainActivity::class.java)
        startActivity(backMain)
        finish()
    }
}