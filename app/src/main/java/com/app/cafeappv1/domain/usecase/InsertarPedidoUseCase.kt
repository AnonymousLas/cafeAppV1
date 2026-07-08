package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.model.Pedido
import com.app.cafeappv1.domain.repository.PedidoRepository

class InsertarPedidoUseCase(
    private val repository: PedidoRepository
) {
    suspend operator fun invoke(pedido: Pedido) {
        repository.insertar(pedido)
    }
}