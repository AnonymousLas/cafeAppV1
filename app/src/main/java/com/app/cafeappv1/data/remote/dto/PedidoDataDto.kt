package com.app.cafeappv1.data.remote.dto

data class PedidoDataDto(
    val items : List<PedidoDto>,
    val nextKey : String?
)
