package com.app.cafeappv1.data.remote.dto

data class ProductoDto(
    val idProducto: String,
    val nombre: String,
    val categoria: String,
    val precio: Double,
    val stock: Int
)
