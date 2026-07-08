package com.app.cafeappv1.data.remote.dto

data class UsuarioApiResponse(
    val success : Boolean,
    val data : UsuarioDataDto,
    val timestamp : String
)
