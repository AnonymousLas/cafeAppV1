package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.model.Usuario
import com.app.cafeappv1.domain.repository.UsuarioRepository

class EliminarUsuarioUseCase(private val repo : UsuarioRepository) {
    suspend operator fun invoke(usuario: Usuario){
        if (usuario.id.isBlank()) throw Exception("Usuario inválido")
        repo.eliminar(usuario)
    }
}