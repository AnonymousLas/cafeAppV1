package com.app.cafeappv1.domain.model

data class Producto(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val precio: Double,
    val stock: Int,

    val imagen: Int=0
)
