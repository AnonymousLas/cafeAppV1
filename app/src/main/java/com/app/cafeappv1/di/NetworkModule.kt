package com.app.cafeappv1.di

import com.app.cafeappv1.core.network.PedidoApiService
import com.app.cafeappv1.core.network.ProductoApiService
import com.app.cafeappv1.core.network.RetrofitClient
import com.app.cafeappv1.core.network.UserApiService

class NetworkModule {

    val userApiService : UserApiService by lazy {
        RetrofitClient.userApiService
    }

    val productoApiService : ProductoApiService by lazy {
        RetrofitClient.productoApiService
    }

    val pedidoApiService : PedidoApiService by lazy {
        RetrofitClient.pedidoApiService
    }

}