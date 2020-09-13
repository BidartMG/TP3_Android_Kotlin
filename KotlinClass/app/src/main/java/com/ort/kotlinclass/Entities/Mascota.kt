package com.ort.kotlinclass.Entities

class Mascota (nombre: String, tipo: String, raza: String, edad: Int) {

    var nombre: String
    var tipo: String
    var raza: String
    var edad: Int

    init {
        this.nombre = nombre
        this.tipo = tipo
        this.raza = raza
        this.edad = edad
    }

    class Constants {
        companion object {
            val typeCan = "PERRO"
            val typeCat = "GATO"
            val typeBird = "AVE"
        }
    }

    fun calcularEdad(edad: Int): Int {
        var edadCalculada = edad * 7
        return edadCalculada
    }
}