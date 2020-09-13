package com.ort.navigation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.ort.navigation2.R
import com.ort.navigation2.fragments.entities.Mascota
import com.ort.navigation2.fragments.entities.User
import kotlinx.android.synthetic.main.fragment_2.*


class Fragment2 : Fragment() {

    lateinit var vista: View
    var mascotas: MutableList<Mascota> = ArrayList<Mascota>()
    lateinit var user: User
    lateinit var cajaTexto: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista =  inflater.inflate(R.layout.fragment_2, container, false)
        cajaTexto = vista.findViewById(R.id.txtView2)

        return vista
    }

    override fun onStart() {
        super.onStart()


        var mascotaName = Fragment2Args.fromBundle(requireArguments()).mascotaName
        var cantidad= Fragment2Args.fromBundle(requireArguments()).cantidad
        var mascotas = Fragment2Args.fromBundle(requireArguments()).listaMascotas.toMutableList()
        var user = Fragment2Args.fromBundle(requireArguments()).user

        var listado: String = ""
        for (mascota in mascotas) {
            listado += mascota.nombre + " " + mascota.tipo + " " + mascota.raza + " " + mascota.calcularEdad() + "\n"
        }
        cajaTexto.setText(mascotaName + "\n" + cantidad + "\n" + user.username + "\n" + listado)

    }


}