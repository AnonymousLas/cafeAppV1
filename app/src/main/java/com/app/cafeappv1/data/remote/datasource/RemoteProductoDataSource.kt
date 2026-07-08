package com.app.cafeappv1.data.remote.datasource

import com.app.cafeappv1.core.network.ProductoApiService
import com.app.cafeappv1.data.remote.dto.InsertarProductoRequest
import com.app.cafeappv1.data.remote.dto.ProductoApiResponse
import com.app.cafeappv1.data.remote.dto.ProductoDto


class RemoteProductoDataSource(private val api: ProductoApiService) {

    suspend fun getProductos(): ProductoApiResponse?{
        return api.getProductos().body()
    }

    suspend fun insertarProducto(request: InsertarProductoRequest) : ProductoDto?{
        return api.insertarProducto(request).body()
    }
}