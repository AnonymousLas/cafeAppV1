package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.repository.PedidoRepository

class GetPedidosUseCase(private val repository: PedidoRepository) {
    suspend operator fun invoke() = repository.getPedidos()
}