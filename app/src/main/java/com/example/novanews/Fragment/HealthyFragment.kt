package com.example.novanews.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.novanews.R
import com.example.novanews.databinding.FragmentHealthyBinding


class HealthyFragment : Fragment() {

    lateinit var healthyBinding: FragmentHealthyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        healthyBinding = FragmentHealthyBinding.inflate(inflater,container,false)

        return healthyBinding.root
    }

}