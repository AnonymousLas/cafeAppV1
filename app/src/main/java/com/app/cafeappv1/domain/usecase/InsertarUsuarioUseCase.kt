package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.model.Usuario
import com.app.cafeappv1.domain.repository.UsuarioRepository

class InsertarUsuarioUseCase(private val repo : UsuarioRepository) {
    suspend operator fun invoke(usuario: Usuario): Usuario {
        if (usuario.nombre.isBlank()) throw Exception("Nombre inválido")
        if (usuario.apellido.isBlank()) throw Exception("Apellido inválido")
        if (usuario.correo.isBlank()) throw Exception("Correo inválido")
        if (usuario.celular.isNullOrBlank()) throw Exception("Celular inválido")

        return repo.insertar(usuario)
    }
}