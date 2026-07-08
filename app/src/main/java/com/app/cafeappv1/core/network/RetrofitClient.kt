package com.app.cafeappv1.core.network

import com.app.cafeappv1.core.utils.ProductoConstantes
import com.app.cafeappv1.core.utils.UsuarioConstantes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.app.cafeappv1.core.utils.PedidoConstantes

object RetrofitClient {
    val userApiService : UserApiService by lazy {
        Retrofit.Builder().baseUrl(UsuarioConstantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(UserApiService::class.java)
    }

    val productoApiService : ProductoApiService by lazy {
        Retrofit.Builder().baseUrl(ProductoConstantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductoApiService::class.java)
    }

    val pedidoApiService: PedidoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(PedidoConstantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PedidoApiService::class.java)
    }
}