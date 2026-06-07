package com.app.cafeappv1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.cafeappv1.presentation.state.AuthUIEvent
import com.app.cafeappv1.presentation.state.AuthUIState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    // ── State (igual que UsuarioUIState en la clase) ──────────────
    private val _uiState = MutableStateFlow(AuthUIState())
    val uiState: StateFlow<AuthUIState> = _uiState

    // ── Events (igual que UsuarioUIEvent en la clase) ─────────────
    private val _event = MutableSharedFlow<AuthUIEvent>()
    val event = _event

    // ── Actualizar campos ─────────────────────────────────────────
    fun onCorreoChange(valor: String) {
        _uiState.update { it.copy(correo = valor, correoError = false) }
    }

    fun onContrasenaChange(valor: String) {
        _uiState.update { it.copy(contrasena = valor, contrasenaError = false) }
    }

    fun toggleMostrarContrasena() {
        _uiState.update { it.copy(mostrarContrasena = !it.mostrarContrasena) }
    }

    fun toggleTerminos() {
        _uiState.update { it.copy(aceptaTerminos = !it.aceptaTerminos, terminosError = false) }
    }

    // ── Iniciar sesión ────────────────────────────────────────────
    fun iniciarSesion() {
        val state = _uiState.value

        if (state.correo.isBlank()) {
            _uiState.update { it.copy(correoError = true) }
            return
        }
        if (state.contrasena.isBlank()) {
            _uiState.update { it.copy(contrasenaError = true) }
            return
        }

        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }

                // TODO: reemplazar con UseCase real de login
                kotlinx.coroutines.delay(800)

                _event.emit(AuthUIEvent.NavigateToHome)

            } catch (e: Exception) {
                _event.emit(AuthUIEvent.ShowSnackbar(e.message ?: "Error al iniciar sesión"))
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    // ── Registrarse ───────────────────────────────────────────────
    fun registrarse() {
        val state = _uiState.value

        // Validaciones (mismo patrón que UsuarioFormScreen en la clase)
        if (state.correo.isBlank()) {
            _uiState.update { it.copy(correoError = true) }
            return
        }
        if (state.contrasena.length < 8) {
            _uiState.update { it.copy(contrasenaError = true) }
            return
        }
        if (!state.aceptaTerminos) {
            _uiState.update { it.copy(terminosError = true) }
            return
        }

        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }

                // TODO: reemplazar con InsertarUsuarioUseCase real
                kotlinx.coroutines.delay(800)

                _event.emit(AuthUIEvent.NavigateToRegistroOk)

            } catch (e: Exception) {
                _event.emit(AuthUIEvent.ShowSnackbar(e.message ?: "Error al registrarse"))
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}
