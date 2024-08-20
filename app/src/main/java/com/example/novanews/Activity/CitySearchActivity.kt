package com.example.novanews.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.novanews.Adapter.CitySearchAdapter
import com.example.novanews.Modal.ModalClass
import com.example.novanews.R
import com.example.novanews.databinding.ActivityCitySearchBinding

class CitySearchActivity : AppCompatActivity() {

    lateinit var citySearchBinding: ActivityCitySearchBinding

    lateinit var cityList: List<ModalClass>
    lateinit var citySearchAdapter: CitySearchAdapter
    lateinit var filterList: MutableList<ModalClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        citySearchBinding = ActivityCitySearchBinding.inflate(layoutInflater)
        setContentView(citySearchBinding.root)

        cityList = listOf(
            ModalClass("United States"),
            ModalClass("India"),
            ModalClass("United Kingdom")
        )
        filterList = cityList.toMutableList()

        citySearchAdapter = CitySearchAdapter(filterList) { selectedCity ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("cityName", selectedCity.cityName)
            startActivity(intent)
        }
        citySearchBinding.rvDAtaCity.layoutManager = LinearLayoutManager(this)
        citySearchBinding.rvDAtaCity.adapter = citySearchAdapter

        citySearchBinding.edtSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
               filterCities(p0)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterCities(p0)
                return false
            }

        })

        countryClick()
    }

    private fun countryClick() {

        citySearchBinding.rvDAtaCity.layoutManager = LinearLayoutManager(this)
        citySearchAdapter = CitySearchAdapter(filterList) { selectedCity ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("cityName", selectedCity.cityName)
            startActivity(intent)
        }
        citySearchBinding.rvDAtaCity.adapter = citySearchAdapter
        citySearchAdapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterCities(query: String?) {
        filterList.clear()
        if (query.isNullOrEmpty()) {
            filterList.addAll(cityList)
        } else {
            filterList.addAll(cityList.filter {
                it.cityName.contains(query, ignoreCase = true)
            })
        }
        citySearchAdapter.notifyDataSetChanged()
    }

}