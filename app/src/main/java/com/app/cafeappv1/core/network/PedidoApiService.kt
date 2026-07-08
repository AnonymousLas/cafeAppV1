package com.app.cafeappv1.core.network

import com.app.cafeappv1.data.remote.dto.InsertarPedidoRequest
import com.app.cafeappv1.data.remote.dto.PedidoApiResponse
import com.app.cafeappv1.data.remote.dto.PedidoDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PedidoApiService {

    @GET("pedido")
    suspend fun getPedidos(): Response<PedidoApiResponse>

    @POST("pedido")
    suspend fun insertarPedido(
        @Body request: InsertarPedidoRequest
    ): Response<PedidoDto>
}