package com.example.novanews.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.novanews.R
import com.example.novanews.databinding.FragmentTechnologyBinding


class TechnologyFragment : Fragment() {

    lateinit var technologyBinding: FragmentTechnologyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        technologyBinding = FragmentTechnologyBinding.inflate(inflater,container,false)

        return technologyBinding.root
    }

}