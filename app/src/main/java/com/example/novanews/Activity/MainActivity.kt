package com.example.novanews.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.novanews.Adapter.PagerAdapter
import com.example.novanews.Fragment.AllFragment
import com.example.novanews.Fragment.EntertainmentFragment
import com.example.novanews.Fragment.HealthyFragment
import com.example.novanews.Fragment.PoliticsFragment
import com.example.novanews.Fragment.PopularFragment
import com.example.novanews.Fragment.ScienceFragment
import com.example.novanews.Fragment.TechnologyFragment
import com.example.novanews.R
import com.example.novanews.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val selectedCity = intent.getStringExtra("cityName")
        mainBinding.txtCity.text = selectedCity

        // Initialize and set up the ViewPager with the PagerAdapter
        val Fadapter = PagerAdapter(this.supportFragmentManager)

        Fadapter.addFragment(PopularFragment(), "Popular")
        Fadapter.addFragment(AllFragment(), "All")
        Fadapter.addFragment(TechnologyFragment(), "Technology")
        Fadapter.addFragment(PoliticsFragment(), "Politics")
        Fadapter.addFragment(HealthyFragment(), "Healthy")
        Fadapter.addFragment(ScienceFragment(), "Science")
        Fadapter.addFragment(EntertainmentFragment(), "Entertainment")

        mainBinding.fragmentView.adapter = Fadapter
        mainBinding.tablayout.setupWithViewPager(mainBinding.fragmentView)


        // Set up the TabLayout with the ViewPager2
//        TabLayoutMediator(mainBinding.tablayout, mainBinding.fragmentView) { tab, position ->
//            tab.text = when (position) {
//                0 -> "Popular"
//                1 -> "All"
//                2 -> "Technology"
//                3 -> "Politics"
//                4 -> "Healthy"
//                5 -> "Science"
//                6 -> "Entertainment"
//                else -> "Popular"
//            }
//        }.attach()
    }
}
