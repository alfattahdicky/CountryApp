package com.example.countryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvCountry: RecyclerView
    private val list = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCountry = findViewById(R.id.rv_country)
        rvCountry.setHasFixedSize(true)

        list.addAll(CountryData.listData)
        showRecyclerCardView()

        val btnAbout: ImageButton = findViewById(R.id.btn_about)
        btnAbout.setOnClickListener(this)
    }

    private fun showRecyclerCardView() {
        rvCountry.layoutManager = LinearLayoutManager(this)
        val cardViewCountryAdapter = CardViewCountryAdapter(list)
        rvCountry.adapter = cardViewCountryAdapter

        cardViewCountryAdapter.setOnItemClickCallback(object : CardViewCountryAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Country) {
                showCountryDetail(data)
            }
        })

    }

    private fun showCountryDetail(country: Country) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", country.name)
        intent.putExtra("image", country.photo)
        intent.putExtra("detail", country.detail)
        intent.putExtra("capital", country.capitalCity)
        intent.putExtra("language", country.nationalLanguage)
        intent.putExtra("independence", country.independenceDay)
        intent.putExtra("wideRegion", country.wideRegion)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        val aboutIntent = Intent(this, AboutActivity::class.java)
        startActivity(aboutIntent)
        finish()
    }
}