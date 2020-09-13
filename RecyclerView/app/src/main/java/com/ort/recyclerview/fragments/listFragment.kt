package com.ort.recyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.recyclerview.R
import com.ort.recyclerview.adapters.MascotaListAdapter
import com.ort.recyclerview.entities.Mascota
import java.text.FieldPosition


class listFragment : Fragment() {

    lateinit var vista: View

    lateinit var recMascotas: RecyclerView

    var mascotas: MutableList<Mascota> = ArrayList<Mascota>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mascotasListAdapter: MascotaListAdapter

    companion object {
        fun newInstance() = listFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_list, container, false)
        recMascotas = vista.findViewById(R.id.rec_mascotas)

        return vista
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

        mascotas.add(Mascota("Pedro",Mascota.Constants.tipoPerro,"Collie",3))
        mascotas.add(Mascota("Rodolfo",Mascota.Constants.tipoPerro,"Fox Terrier",4))
        mascotas.add(Mascota("Emilio",Mascota.Constants.tipoPerro,"Gran Danes",5))
        mascotas.add(Mascota("Luis",Mascota.Constants.tipoGato,"Siames",6))
        mascotas.add(Mascota("Carlos",Mascota.Constants.tipoGato,"Pardo",7))
        mascotas.add(Mascota("David",Mascota.Constants.tipoGato,"Arlequin",8))

        recMascotas.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(context)
        recMascotas.layoutManager = linearLayoutManager

        mascotasListAdapter = MascotaListAdapter(mascotas)

        recMascotas.adapter = mascotasListAdapter

    }

    fun onItemClick(position: Int) {
        Snackbar.make(vista,position.toString(),Snackbar.LENGTH_SHORT).show()
    }


}