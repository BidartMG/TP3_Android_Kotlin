package com.ort.desafionavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.ort.desafionavigation.entities.User

class FragmentLogin : Fragment() {
    lateinit var v: View
    lateinit var edt_Texto: EditText
    lateinit var usuario: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false)
        edt_Texto = v.findViewById(R.id.edt_welcome)

        return v
    }

    override fun onStart() {
        super.onStart()

        usuario = FragmentLoginArgs.fromBundle(requireArguments()).usuario

        edt_Texto.setText("Welcome ${usuario.username} \n ♥")
    }

}