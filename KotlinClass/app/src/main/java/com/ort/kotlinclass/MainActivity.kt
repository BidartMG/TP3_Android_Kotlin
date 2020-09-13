package com.ort.kotlinclass

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.ort.kotlinclass.Entities.Mascota

class MainActivity : AppCompatActivity() {

    var mascotas: MutableList<Mascota> = ArrayList<Mascota>()

    lateinit var mascota: Mascota
    lateinit var cartel: String

    lateinit var txtCartel: TextView
    lateinit var btnShow: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCartel = findViewById(R.id.txtInicio)
        btnShow = findViewById(R.id.btnInicio)


        // Cargo el MutableList con mascotas incluyendo el constructor
        mascotas.add(Mascota("Pedro",Mascota.Constants.typeCan,"Collie",3))
        mascotas.add(Mascota("Rodolfo",Mascota.Constants.typeCan,"Fox Terrier",4))
        mascotas.add(Mascota("Emilio",Mascota.Constants.typeCan,"Gran Danés",5))
        mascotas.add(Mascota("Luis", Mascota.Constants.typeCat,"Persa",7))
        mascotas.add(Mascota("Carlos",Mascota.Constants.typeCat,"Siames",6))
        mascotas.add(Mascota("David",Mascota.Constants.typeBird,"Canario",8))

        // Instancio una mascota que no está en el MutableList
        mascota = Mascota("Pepe",Mascota.Constants.typeBird,"Loro",10)

        // Recorro y muestro por consola los elementos que están en el ArrayList
        for (mascotaActual in mascotas) {
            var edad = mascotaActual.edad
            Log.d("MainActivity",mascotaActual.nombre+" "+mascotaActual.tipo+" "+mascotaActual.raza+" edad: "+mascotaActual.calcularEdad(edad)+"\n")
        }

        // Cambio el nombre a uno de los elementos del ArrayList
        mascotas[1].nombre = "Nombre Nuevo"

        // Muestro el elemento cambiado
        Log.d("Activity Main",mascotas[1].nombre)

        fun escribirCartel(texto:String) {
            txtCartel.text = texto
        }

        btnShow.setOnClickListener() {
            escribirCartel("Buenos días Su Señoría...")
        }












    }
}