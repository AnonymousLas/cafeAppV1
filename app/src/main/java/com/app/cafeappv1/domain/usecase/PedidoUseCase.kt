package com.app.cafeappv1.domain.usecase

data class PedidoUseCase(
    val getPedidos : GetPedidosUseCase,
    val insertarPedido: InsertarPedidoUseCase
)
