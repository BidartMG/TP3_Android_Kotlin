package com.ort.navigation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.ort.navigation2.fragments.entities.Mascota

import com.ort.navigation2.R
import com.ort.navigation2.fragments.entities.User


class Fragment1 : Fragment() {
    lateinit var vista: View
    lateinit var boton: Button

    lateinit var valorCadena: String
    lateinit var usuario: User

    var mascotas: MutableList<Mascota> = ArrayList<Mascota>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_1, container, false)

        // Inflate the layout for this fragment
        boton = vista.findViewById(R.id.btnGoToF2)
        return vista
    }

    override fun onStart() {
        super.onStart()

        usuario = User("MonicaGB","210368")

        mascotas.add(Mascota("Luli",Mascota.Constants.tipoPerro,"Caniche",7))
        mascotas.add(Mascota("Neinin",Mascota.Constants.tipoGato,"Rubio Callejero",4))
        mascotas.add(Mascota("Astor",Mascota.Constants.tipoPerro,"Border Collie",1))

        boton.setOnClickListener() {

            valorCadena="Meredith"
            val action2 = Fragment1Directions.actionFragment1ToFragment2(valorCadena,52,usuario,mascotas.toTypedArray())
            vista.findNavController().navigate(action2)
        }
    }

}