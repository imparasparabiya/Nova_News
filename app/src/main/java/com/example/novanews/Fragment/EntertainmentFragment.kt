package com.example.novanews.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.novanews.R
import com.example.novanews.databinding.FragmentEntertainmentBinding


class EntertainmentFragment : Fragment() {

    lateinit var entertainmentBinding: FragmentEntertainmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        entertainmentBinding = FragmentEntertainmentBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment


        return entertainmentBinding.root
    }


}