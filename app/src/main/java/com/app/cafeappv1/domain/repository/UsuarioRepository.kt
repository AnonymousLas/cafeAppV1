package com.app.cafeappv1.domain.repository

import com.app.cafeappv1.domain.model.Usuario

interface UsuarioRepository {

    suspend fun insertar(usuario: Usuario): Usuario
    suspend fun actualizar(usuario: Usuario)
    suspend fun eliminar(usuario: Usuario)
    suspend fun getUsuarios() : List<Usuario>
    suspend fun getById(id: String) : Usuario
}