package com.app.cafeappv1.data.remote.dto

data class RegistroApiResponse(
    val success: Boolean,
    val data: UsuarioDto,
    val timestamp: String
)