package com.app.cafeappv1.di

import com.app.cafeappv1.presentation.viewmodel.AuthViewModel
import com.app.cafeappv1.presentation.viewmodel.PedidoViewModel
import com.app.cafeappv1.presentation.viewmodel.ProductoViewModel

class AppContainer {

    private val networkModule by lazy { NetworkModule() }

    private val repositoryModule by lazy { RepositoryModule(networkModule) }

    private val useCaseModule by lazy { UseCaseModule(repositoryModule) }

    val authViewModel by lazy {
        AuthViewModel(useCaseModule.usuarioUseCases)
    }

    val productoViewModel by lazy {
        ProductoViewModel(useCaseModule.productoUseCases)
    }

    val pedidoViewModel by lazy {
        PedidoViewModel(useCaseModule.pedidoUseCases)
    }
}