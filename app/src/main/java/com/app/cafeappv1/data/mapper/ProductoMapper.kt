package com.app.cafeappv1.data.mapper

import com.app.cafeappv1.data.remote.dto.InsertarProductoRequest
import com.app.cafeappv1.data.remote.dto.ProductoDto
import com.app.cafeappv1.domain.model.Producto

object ProductoMapper {

    fun toDomain(producto: ProductoDto): Producto = Producto(
        producto.idProducto.toIntOrNull() ?:0,
        producto.nombre,
        producto.categoria,
        producto.precio,
        producto.stock,
    )

    fun toInsertarProductoRequest(producto: Producto) : InsertarProductoRequest =
        InsertarProductoRequest(
            producto.nombre,
            producto.categoria,
            producto.precio,
            producto.stock,
        )

}