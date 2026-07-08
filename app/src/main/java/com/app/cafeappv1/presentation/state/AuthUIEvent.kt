package com.app.cafeappv1.presentation.state

sealed class AuthUIEvent {
    data class ShowSnackbar(val mensaje: String) : AuthUIEvent()
    object NavigateToHome      : AuthUIEvent()
    object NavigateToRegistroOk: AuthUIEvent()
    object NavigateToRegistro  : AuthUIEvent()
}
