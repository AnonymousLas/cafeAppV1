package com.app.cafeappv1.domain.model

data class Pedido(

    val idPedido: String = "",
    val idProducto: String,
    val productoNombre: String,
    val cantidad: Int,
    val metodoPago: String,
    val total: Double,
    val fecha: String

)