package com.app.cafeappv1.di

import com.app.cafeappv1.domain.usecase.GetPedidosUseCase
import com.app.cafeappv1.domain.usecase.GetProductosUseCase
import com.app.cafeappv1.domain.usecase.GetUsuariosUseCase
import com.app.cafeappv1.domain.usecase.InsertarPedidoUseCase
import com.app.cafeappv1.domain.usecase.InsertarProductoUseCase
import com.app.cafeappv1.domain.usecase.InsertarUsuarioUseCase
import com.app.cafeappv1.domain.usecase.PedidoUseCase
import com.app.cafeappv1.domain.usecase.ProductoUseCase
import com.app.cafeappv1.domain.usecase.UsuarioUseCase

class UseCaseModule(repositoryModule: RepositoryModule) {

    val usuarioUseCases by lazy {

        UsuarioUseCase(
            GetUsuariosUseCase(repositoryModule.usuarioRepository),
            InsertarUsuarioUseCase(repositoryModule.usuarioRepository)
        )
    }

    val productoUseCases by lazy {
        ProductoUseCase(
            GetProductosUseCase(repositoryModule.productoRepository),
            InsertarProductoUseCase(repositoryModule.productoRepository)
        )
    }

    val pedidoUseCases by lazy {
        PedidoUseCase(
            GetPedidosUseCase(repositoryModule.pedidoRepository),
            InsertarPedidoUseCase(repositoryModule.pedidoRepository)
        )
    }
}