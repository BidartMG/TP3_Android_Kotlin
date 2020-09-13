package com.ort.userinterface2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var txt_texto: TextView
    lateinit var edt_input_text: EditText
    lateinit var btn_acceptar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_texto = findViewById(R.id.txt_view)
        edt_input_text = findViewById(R.id.edt_input)
        btn_acceptar = findViewById(R.id.btn_show)

        btn_acceptar.setOnClickListener() {
            if(edt_input_text.length() > 0) {
                txt_texto.text = "Texto Ingresado: " + edt_input_text.text
                edt_input_text.setText("")

            } else {
                Snackbar.make(root_layout,"CAMPO DE DATOS VACÍO ...",Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}