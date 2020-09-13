package com.ort.recyclerview.entities

import android.os.Parcel
import android.os.Parcelable

class Mascota (nombre: String,tipo: String,raza: String,edad: Int) : Parcelable{
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
            val tipoPerro = "PERRO"
            val tipoGato = "GATO"
        }
    }

    fun calcularEdad():Int {
        return this.edad * 7
    }

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(tipo)
        parcel.writeString(raza)
        parcel.writeInt(edad)
    }


    companion object CREATOR : Parcelable.Creator<Mascota> {
        override fun createFromParcel(parcel: Parcel): Mascota {
            return Mascota(parcel)
        }

        override fun newArray(size: Int): Array<Mascota?> {
            return arrayOfNulls(size)
        }
    }


}