package com.app.cafeappv1.data.remote.datasource

import com.app.cafeappv1.core.network.UserApiService
import com.app.cafeappv1.data.remote.dto.InsertarUsuarioRequest
import com.app.cafeappv1.data.remote.dto.UsuarioApiResponse
import com.app.cafeappv1.data.remote.dto.UsuarioDto

class RemoteUserDataSource(private val api: UserApiService) {

    suspend fun getUsers(): UsuarioApiResponse?{
        return api.getUsuarios().body()
    }

    suspend fun insertarUsuario(request: InsertarUsuarioRequest) : UsuarioDto?{
        return api.insertarUsuario(request).body()
    }

    suspend fun registrarUsuario(request: InsertarUsuarioRequest) : UsuarioDto?{
        return api.registrarUsuario(request).body()?.data
    }
}