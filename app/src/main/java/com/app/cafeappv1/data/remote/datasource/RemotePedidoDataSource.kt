package com.app.cafeappv1.data.remote.datasource

import com.app.cafeappv1.core.network.PedidoApiService
import com.app.cafeappv1.core.network.ProductoApiService
import com.app.cafeappv1.data.remote.dto.InsertarPedidoRequest
import com.app.cafeappv1.data.remote.dto.InsertarProductoRequest
import com.app.cafeappv1.data.remote.dto.PedidoApiResponse
import com.app.cafeappv1.data.remote.dto.PedidoDto
import com.app.cafeappv1.data.remote.dto.ProductoApiResponse
import com.app.cafeappv1.data.remote.dto.ProductoDto

class RemotePedidoDataSource(private val api: PedidoApiService) {

    suspend fun getPedidos(): PedidoApiResponse?{
        return api.getPedidos().body()
    }

    //suspend fun insertarPedido(request: InsertarPedidoRequest) : PedidoDto?{
       // return api.insertarPedido(request).body()
    //}

    suspend fun insertarPedido(request: InsertarPedidoRequest) {
        val response = api.insertarPedido(request)

        println("REQUEST PEDIDO: $request")
        println("CODIGO PEDIDO: ${response.code()}")
        println("BODY PEDIDO: ${response.body()}")
        println("ERROR PEDIDO: ${response.errorBody()?.string()}")
    }
}