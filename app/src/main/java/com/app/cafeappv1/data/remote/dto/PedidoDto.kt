package com.app.cafeappv1.data.remote.dto

data class PedidoDto(
    val idPedido: String,
    val idProducto: String,
    val productoNombre: String,
    val cantidad: Int,
    val metodoPago: String,
    val total: Double,
    val fecha: String
)