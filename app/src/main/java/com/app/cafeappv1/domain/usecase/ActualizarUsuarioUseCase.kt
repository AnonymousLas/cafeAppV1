package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.model.Usuario
import com.app.cafeappv1.domain.repository.UsuarioRepository

class ActualizarUsuarioUseCase (private val repo: UsuarioRepository) {
    suspend operator fun invoke(usuario: Usuario){
        if (usuario.id.isBlank()) throw Exception("ID es inválido")
        if (usuario.nombre.isBlank()) throw Exception("Nombre inválido")
        if (usuario.correo.isBlank()) throw Exception("Correo inválido")

        repo.actualizar(usuario)
    }
}