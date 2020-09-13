package com.ort.kotlinclass.Entities

class User (nombre: String, apellido: String, username: String, password: String) {

    var nombre: String
    var apellido: String
    var username: String
    var password: String

    init {
        this.apellido = apellido
        this.nombre = nombre
        this.username = username
        this.password = password
    }
}