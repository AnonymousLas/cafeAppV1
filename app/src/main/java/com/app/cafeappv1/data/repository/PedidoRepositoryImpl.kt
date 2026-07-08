package com.app.cafeappv1.data.repository

import com.app.cafeappv1.core.network.PedidoApiService
import com.app.cafeappv1.data.mapper.PedidoMapper
import com.app.cafeappv1.data.mapper.ProductoMapper
import com.app.cafeappv1.data.remote.datasource.RemotePedidoDataSource
import com.app.cafeappv1.data.remote.datasource.RemoteProductoDataSource
import com.app.cafeappv1.domain.model.Pedido
import com.app.cafeappv1.domain.model.Producto
import com.app.cafeappv1.domain.repository.PedidoRepository
import com.app.cafeappv1.domain.repository.ProductoRepository

class PedidoRepositoryImpl(private val remotePedidoDataSource: RemotePedidoDataSource): PedidoRepository{

    override suspend fun insertar(pedido: Pedido) {
        remotePedidoDataSource.insertarPedido(PedidoMapper.toInsertarPedidoRequest(pedido))

    }

    override suspend fun getPedidos(): List<Pedido> {
        return remotePedidoDataSource.getPedidos()?.data?.items?.map {
            PedidoMapper.toDomain(it)
        }?: emptyList()
    }


}