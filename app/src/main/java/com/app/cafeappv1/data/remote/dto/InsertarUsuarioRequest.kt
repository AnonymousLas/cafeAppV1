package com.app.cafeappv1.data.remote.dto

data class InsertarUsuarioRequest(
    val nombre: String,
    val apellido: String,
    val correo: String,
    val celular: String? = null,
    val direccion: String? = null,
    val fechaNac: String? = null,
    val pagoFav: String? = null
)
