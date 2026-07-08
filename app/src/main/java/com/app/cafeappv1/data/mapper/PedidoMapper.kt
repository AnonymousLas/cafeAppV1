package com.app.cafeappv1.data.mapper

import com.app.cafeappv1.data.remote.dto.InsertarPedidoRequest
import com.app.cafeappv1.data.remote.dto.PedidoDto
import com.app.cafeappv1.data.remote.dto.ProductoDto
import com.app.cafeappv1.domain.model.Pedido
import com.app.cafeappv1.domain.model.Producto

object PedidoMapper {

    fun toDomain(pedido: PedidoDto): Pedido = Pedido(
        pedido.idPedido,
        pedido.idProducto,
        pedido.productoNombre,
        pedido.cantidad,
        pedido.metodoPago,
        pedido.total,
        pedido.fecha
    )

    fun toInsertarPedidoRequest(pedido: Pedido): InsertarPedidoRequest {
        return InsertarPedidoRequest(
            idPedido = pedido.idPedido,
            idProducto = pedido.idProducto,
            productoNombre = pedido.productoNombre,
            cantidad = pedido.cantidad,
            metodoPago = pedido.metodoPago,
            total = pedido.total,
            fecha = pedido.fecha
        )
    }
}