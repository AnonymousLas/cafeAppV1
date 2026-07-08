package com.app.cafeappv1.data.remote.dto

data class PedidoApiResponse(
    val success : Boolean,
    val data : PedidoDataDto,
    val timestamp : String
)
