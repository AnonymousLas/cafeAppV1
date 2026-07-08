package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.model.Producto
import com.app.cafeappv1.domain.repository.ProductoRepository

class ActualizarProductoUseCase(private val repo: ProductoRepository) {
    suspend operator fun invoke(producto: Producto){
        if (producto.id <= 0) throw Exception("ID es inválido")
        if (producto.nombre.isBlank()) throw Exception("Nombre inválido")
        if (producto.precio < 0) throw Exception("Precio inválido")

        repo.actualizar(producto)
    }
}