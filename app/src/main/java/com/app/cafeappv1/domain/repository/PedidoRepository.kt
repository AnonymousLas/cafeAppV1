package com.app.cafeappv1.domain.repository

import com.app.cafeappv1.domain.model.Pedido

interface PedidoRepository {
    suspend fun insertar(pedido: Pedido)
    suspend fun getPedidos() : List<Pedido>
}