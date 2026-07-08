package com.app.cafeappv1.core.network


import com.app.cafeappv1.data.remote.dto.InsertarProductoRequest
import com.app.cafeappv1.data.remote.dto.ProductoApiResponse
import com.app.cafeappv1.data.remote.dto.ProductoDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductoApiService {
    @GET("producto")
    suspend fun getProductos() : Response<ProductoApiResponse>

    @POST("producto")
    suspend fun insertarProducto(@Body request: InsertarProductoRequest) : Response<ProductoDto>
}