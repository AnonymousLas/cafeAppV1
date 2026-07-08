package com.app.cafeappv1.data.remote.repository

import com.app.cafeappv1.data.mapper.ProductoMapper
import com.app.cafeappv1.data.mapper.UsuarioMapper
import com.app.cafeappv1.data.remote.datasource.RemoteProductoDataSource
import com.app.cafeappv1.domain.model.Producto
import com.app.cafeappv1.domain.repository.ProductoRepository

class ProductoRepositorioImpl(private val remoteProductoDataSource: RemoteProductoDataSource): ProductoRepository {
    override suspend fun insertar(producto: Producto) {
        remoteProductoDataSource.insertarProducto(ProductoMapper.toInsertarProductoRequest(producto))

    }

    override suspend fun actualizar(producto: Producto) {
        TODO("Not yet implemented")
    }

    override suspend fun eliminar(producto: Producto) {
        TODO("Not yet implemented")
    }

    override suspend fun getProductos(): List<Producto> {
        return remoteProductoDataSource.getProductos()?.data?.items?.map {
            ProductoMapper.toDomain(it)
        }?: emptyList()
    }

    override suspend fun getById(id: Int): Producto {
        TODO("Not yet implemented")
    }

}