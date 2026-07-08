package com.app.cafeappv1.di

import com.app.cafeappv1.data.remote.datasource.RemotePedidoDataSource
import com.app.cafeappv1.data.remote.datasource.RemoteProductoDataSource
import com.app.cafeappv1.data.remote.datasource.RemoteUserDataSource
import com.app.cafeappv1.data.remote.repository.ProductoRepositorioImpl
import com.app.cafeappv1.data.remote.repository.UsuarioRepositorioImpl
import com.app.cafeappv1.data.repository.PedidoRepositoryImpl
import com.app.cafeappv1.domain.repository.PedidoRepository
import com.app.cafeappv1.domain.repository.ProductoRepository
import com.app.cafeappv1.domain.repository.UsuarioRepository

class RepositoryModule(networkModule: NetworkModule) {
    private val remoteUserDataSource by lazy {
        RemoteUserDataSource(networkModule.userApiService)
    }

    val usuarioRepository : UsuarioRepository by lazy {
        UsuarioRepositorioImpl(remoteUserDataSource)
    }


    private val remoteProductoDataSource by lazy {
        RemoteProductoDataSource(networkModule.productoApiService)
    }

    val productoRepository : ProductoRepository by lazy {
        ProductoRepositorioImpl(remoteProductoDataSource)
    }

    private val remotePedidoDataSource by lazy {
        RemotePedidoDataSource(networkModule.pedidoApiService)
    }
    val pedidoRepository : PedidoRepository by lazy {
        PedidoRepositoryImpl(remotePedidoDataSource)
    }
}