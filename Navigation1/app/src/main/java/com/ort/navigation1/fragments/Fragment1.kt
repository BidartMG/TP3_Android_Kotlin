package com.ort.navigation1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.ort.navigation1.R
import kotlinx.android.synthetic.*


class Fragment1 : Fragment() {

    lateinit var vista: View
    lateinit var btnIrF2: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_1, container, false)
        btnIrF2 = vista.findViewById(R.id.btn_goTo_fragment2)
        return vista
    }

    override fun onStart() {
        super.onStart()

        btnIrF2.setOnClickListener() {
            val action2 = Fragment1Directions.actionFragment1ToFragment2()
            vista.findNavController().navigate(action2)
        }
    }


}





















