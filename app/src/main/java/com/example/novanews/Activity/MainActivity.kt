package com.example.novanews.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.novanews.Adapter.PagerAdapter
import com.example.novanews.Adapter.PopularAdapter
import com.example.novanews.Client.NewsAPIClient
import com.example.novanews.Fragment.AllFragment
import com.example.novanews.Fragment.EntertainmentFragment
import com.example.novanews.Fragment.HealthyFragment
import com.example.novanews.Fragment.PoliticsFragment
import com.example.novanews.Fragment.PopularFragment
import com.example.novanews.Fragment.ScienceFragment
import com.example.novanews.Fragment.TechnologyFragment
import com.example.novanews.Helper.AuthHelper.Companion.authHelper
import com.example.novanews.Interface.NewsAPIInterface
import com.example.novanews.Modal.PopularModal
import com.example.novanews.R
import com.example.novanews.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

       // TODO("Log Out Butten Click")
        mainBinding.btnLogOut.setOnClickListener {
            authHelper.logOut()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val selectedCity = intent.getStringExtra("cityName")
        mainBinding.txtCity.text = selectedCity

        // Initialize and set up the ViewPager with the PagerAdapter
        setAdepter()
        // Set the default fragment to PopularFragment
        val popularFragment = PopularFragment()
        replaceFragment(popularFragment)


    }



    fun setAdepter() {
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
    }
    fun replaceFragment(fragment: androidx.fragment.app.Fragment) {

        var fragmenrTransaction = supportFragmentManager.beginTransaction()
       fragmenrTransaction.replace(R.id.fragmentView, fragment)
        fragmenrTransaction.addToBackStack(null)
        fragmenrTransaction.commit()
    }
}
