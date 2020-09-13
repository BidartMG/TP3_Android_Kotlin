package com.ort.desafiologin

import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.ort.desafiologin.entities.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btnSender: Button
    lateinit var edtUser: EditText
    lateinit var edtPass: EditText

    var usuarios: MutableList<User> = ArrayList<User>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSender = findViewById(R.id.btn_login)
        edtUser = findViewById(R.id.edt_username)
        edtPass = findViewById(R.id.edt_pass)

        fun buscarUsuario(nombre: String,pass: String): Boolean {
            var encontre = false

            for (user in usuarios) {
                if(user.username == nombre && user.password == pass) {
                    encontre = true
                }
            }
            return encontre
        }

        btnSender.setOnClickListener() {

            if (edtUser.length() > 0 && edtPass.length() > 0) {
                if(buscarUsuario(edtUser.text.toString(),edtPass.text.toString())) {
                    Snackbar.make(root_layout,"USUARIO VALIDO - Bienvenido ${edtUser.text}",Snackbar.LENGTH_SHORT).show()
                }
                else {
                    Snackbar.make(root_layout,"USUARIO INVALIDO",Snackbar.LENGTH_SHORT).show()
                }
            }
            else {
                // Avisar que no ingreso el usuario
                Snackbar.make(root_layout,"DEBE LLENAR TODOS LOS CAMPOS",Snackbar.LENGTH_SHORT).show()
            }
        }

        usuarios.add(User("Monica","2103"))
        usuarios.add(User("Marcelo","1012"))
        usuarios.add(User("Lucas","1307"))
        usuarios.add(User("Nicolas","1309"))
        usuarios.add(User("Celeste","0503"))


    }
}