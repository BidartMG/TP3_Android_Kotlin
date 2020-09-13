package com.ort.desafionavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ort.desafionavigation.entities.User
import kotlinx.android.synthetic.main.fragment_inicio.*

class FragmentInicio : Fragment() {

    lateinit var vista: View
    lateinit var btn_login: Button
    lateinit var edtUser: EditText
    lateinit var edtPass: EditText

    lateinit var elUser: User
    var usuarios: MutableList<User> = ArrayList<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_inicio, container, false)
        btn_login = vista.findViewById(R.id.btn_log)
        edtUser = vista.findViewById(R.id.edt_user)
        edtPass = vista.findViewById(R.id.edt_pass)

        return vista
    }

    fun buscarUsuario(nombre:String,pass:String): Boolean {
        var encontre: Boolean = false

        for (actualUser in usuarios) {
            if(actualUser.username == nombre){
                if (actualUser.password == pass){
                    encontre = true
                }
            }
        }
        return encontre
    }

    override fun onStart() {
        super.onStart()

        usuarios.add(User("Marce","1012"))
        usuarios.add(User("Yop","2103"))
        usuarios.add(User("Luck","1307"))
        usuarios.add(User("Nick","1309"))
        usuarios.add(User("Celes","0503"))

        btn_login.setOnClickListener() {
            var username  = edtUser.text.toString()
            var password = edtPass.text.toString()

            if (buscarUsuario(username,password)) {
                elUser = User(username,password)
                val enviarUsuario = FragmentInicioDirections.actionFragmentInicioToFragmentLogin(elUser)
                vista.findNavController().navigate(enviarUsuario)
            }
            else {
                Snackbar.make(frameLayout,"USUARIO INVALIDO ", Snackbar.LENGTH_SHORT).show()
            }
        }

    }



}