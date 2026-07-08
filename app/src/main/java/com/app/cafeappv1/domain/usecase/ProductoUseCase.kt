package com.app.cafeappv1.domain.usecase

data class ProductoUseCase(

    //val actualizarProducto: ActualizarProductoUseCase,
    val getProductos : GetProductosUseCase,
    val insertarProducto: InsertarProductoUseCase
)