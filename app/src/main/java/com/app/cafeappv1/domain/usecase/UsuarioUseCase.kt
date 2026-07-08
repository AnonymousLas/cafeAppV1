package com.app.cafeappv1.domain.usecase

data class UsuarioUseCase (
    /*
    val actualizarUsuario : ActualizarUsuarioUseCase,
    val eliminarUsuario : EliminarUsuarioUseCase,
    */
    val getUsuarios : GetUsuariosUseCase,
    val insertarUsuario : InsertarUsuarioUseCase
)