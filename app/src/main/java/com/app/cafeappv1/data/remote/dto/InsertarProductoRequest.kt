package com.app.cafeappv1.data.remote.dto

data class InsertarProductoRequest(
    val nombre: String,
    val categoria: String,
    val precio: Double,
    val stock: Int
)
