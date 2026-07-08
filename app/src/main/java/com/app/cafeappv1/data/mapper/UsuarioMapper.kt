package com.app.cafeappv1.data.mapper

import com.app.cafeappv1.data.remote.dto.InsertarUsuarioRequest
import com.app.cafeappv1.data.remote.dto.UsuarioDto
import com.app.cafeappv1.domain.model.Usuario

object UsuarioMapper {
    fun toDomain(usuarioDto: UsuarioDto): Usuario = Usuario(
        usuarioDto.id,
        usuarioDto.nombre,
        usuarioDto.apellido,
        usuarioDto.correo,
        usuarioDto.celular,
        usuarioDto.direccion,
        usuarioDto.fechaNac,
        usuarioDto.pagoFav
    )

    fun toInsertarUsuarioRequest(usuario: Usuario) : InsertarUsuarioRequest =
        InsertarUsuarioRequest(
            usuario.nombre,
            usuario.apellido,
            usuario.correo,
            usuario.celular,
            usuario.direccion,
            usuario.fechaNac,
            usuario.pagoFav
        )
}