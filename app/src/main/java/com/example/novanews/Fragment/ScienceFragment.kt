package com.example.novanews.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.novanews.R
import com.example.novanews.databinding.FragmentScienceBinding


class ScienceFragment : Fragment() {

    lateinit var scienceBinding: FragmentScienceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        scienceBinding = FragmentScienceBinding.inflate(inflater, container, false)
        return scienceBinding.root
    }

}