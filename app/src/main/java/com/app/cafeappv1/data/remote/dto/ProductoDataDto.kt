package com.app.cafeappv1.data.remote.dto

data class ProductoDataDto (
    val items : List<ProductoDto>,
    val nextKey : String?
)