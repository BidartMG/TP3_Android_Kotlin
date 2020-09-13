package com.ort.desafionavigation.entities

import android.os.Parcel
import android.os.Parcelable


class User (username: String, password: String) :Parcelable{
    var username: String
    var password: String

    init {
        this.password = password
        this.username = username
    }

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flag: Int) {
        parcel.writeString(username)
        parcel.writeString(password)
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    fun esValido (username: String, pass: String): Boolean {
        var coincide: Boolean = false
        if(this.username == username && this.password == pass) {
            coincide = true
        }
        return coincide
    }
}