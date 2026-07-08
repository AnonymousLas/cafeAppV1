package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.repository.ProductoRepository

class GetProductosUseCase(private val repository: ProductoRepository) {
    suspend operator fun invoke() = repository.getProductos()

}