package com.app.cafeappv1.data.remote.dto

data class ProductoApiResponse(
    val success : Boolean,
    val data : ProductoDataDto,
    val timestamp : String
)
