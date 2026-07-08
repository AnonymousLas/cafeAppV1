package com.app.cafeappv1.domain.usecase

import com.app.cafeappv1.domain.repository.UsuarioRepository

class GetUsuariosUseCase(private val repo: UsuarioRepository) {
    suspend operator fun invoke() = repo.getUsuarios()
}