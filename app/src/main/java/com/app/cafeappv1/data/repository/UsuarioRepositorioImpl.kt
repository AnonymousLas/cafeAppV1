package com.app.cafeappv1.data.remote.repository

import com.app.cafeappv1.data.mapper.UsuarioMapper
import com.app.cafeappv1.data.remote.datasource.RemoteUserDataSource
import com.app.cafeappv1.domain.model.Usuario
import com.app.cafeappv1.domain.repository.UsuarioRepository

class UsuarioRepositorioImpl(private val remoteUserDataSource: RemoteUserDataSource):
    UsuarioRepository {
    override suspend fun insertar(usuario: Usuario): Usuario {
        val creado = remoteUserDataSource.registrarUsuario(UsuarioMapper.toInsertarUsuarioRequest(usuario))
            ?: throw Exception("No se pudo registrar el usuario")
        return UsuarioMapper.toDomain(creado)
    }

    override suspend fun actualizar(usuario: Usuario) {
        TODO("Not yet implemented")
    }

    override suspend fun eliminar(usuario: Usuario) {
        TODO("Not yet implemented")
    }

    override suspend fun getUsuarios(): List<Usuario> {
        return remoteUserDataSource.getUsers()?.data?.items?.map {
            UsuarioMapper.toDomain(it)
        }?: emptyList()
    }

    override suspend fun getById(id: String): Usuario {
        TODO("Not yet implemented")
    }
}