package com.app.cafeappv1.domain.model

data class Usuario(
    val id: String = "",
    val nombre: String,
    val apellido: String,
    val correo: String,
    val celular: String? = null,
    val direccion: String? = null,
    val fechaNac: String? = null,
    val pagoFav: String?
)