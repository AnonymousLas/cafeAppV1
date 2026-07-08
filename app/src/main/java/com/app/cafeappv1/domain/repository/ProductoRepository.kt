package com.app.cafeappv1.domain.repository

import com.app.cafeappv1.domain.model.Producto
import com.app.cafeappv1.domain.model.Usuario

interface ProductoRepository {
    suspend fun insertar(producto: Producto)
    suspend fun actualizar(producto: Producto)
    suspend fun eliminar(producto: Producto)
    suspend fun getProductos() : List<Producto>
    suspend fun getById(id: Int) : Producto
}