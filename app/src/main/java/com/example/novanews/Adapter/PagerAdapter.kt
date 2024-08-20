package com.example.novanews.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.novanews.Fragment.AllFragment
import com.example.novanews.Fragment.EntertainmentFragment
import com.example.novanews.Fragment.HealthyFragment
import com.example.novanews.Fragment.PoliticsFragment
import com.example.novanews.Fragment.PopularFragment
import com.example.novanews.Fragment.ScienceFragment
import com.example.novanews.Fragment.TechnologyFragment

class PagerAdapter(fragment: FragmentManager) : FragmentPagerAdapter(
    fragment,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
   var fragmentList : ArrayList<Fragment> = ArrayList()
    var fragmentTitle : ArrayList<String> = ArrayList()


    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
//        return when (position) {
//            0 -> PopularFragment()
//            1 -> AllFragment()
//            2 -> TechnologyFragment()
//            3 -> PoliticsFragment()
//            4 -> HealthyFragment()
//            5 -> ScienceFragment()
//            6 -> EntertainmentFragment()
//            else -> PopularFragment()
//        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }
}
