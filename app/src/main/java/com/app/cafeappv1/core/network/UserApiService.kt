package com.app.cafeappv1.core.network

import com.app.cafeappv1.data.remote.dto.InsertarUsuarioRequest
import com.app.cafeappv1.data.remote.dto.RegistroApiResponse
import com.app.cafeappv1.data.remote.dto.UsuarioApiResponse
import com.app.cafeappv1.data.remote.dto.UsuarioDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    @GET("user")
    suspend fun getUsuarios() : Response<UsuarioApiResponse>

    @POST("user")
    suspend fun insertarUsuario(@Body request: InsertarUsuarioRequest) : Response<UsuarioDto>

    // Endpoint real de registro, probado por curl: POST /register
    @POST("register")
    suspend fun registrarUsuario(@Body request: InsertarUsuarioRequest) : Response<RegistroApiResponse>
}