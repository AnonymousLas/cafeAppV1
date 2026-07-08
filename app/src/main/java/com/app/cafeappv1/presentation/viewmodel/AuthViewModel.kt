package com.app.cafeappv1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.cafeappv1.domain.model.Usuario
import com.app.cafeappv1.domain.session.SessionManager
import com.app.cafeappv1.domain.usecase.UsuarioUseCase
import com.app.cafeappv1.presentation.state.AuthUIEvent
import com.app.cafeappv1.presentation.state.AuthUIState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(private val useCase: UsuarioUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUIState())
    val uiState: StateFlow<AuthUIState> = _uiState

    private val _event = MutableSharedFlow<AuthUIEvent>()
    val event = _event

    fun onCorreoChange(valor: String) {
        _uiState.update { it.copy(correo = valor, correoError = false) }
    }

    fun onCelularChange(valor: String) {
        _uiState.update { it.copy(celular = valor, celularError = false) }
    }

    fun toggleMostrarCelular() {
        _uiState.update { it.copy(mostrarCelular = !it.mostrarCelular) }
    }

    fun onNombreChange(valor: String) {
        _uiState.update { it.copy(nombre = valor, nombreError = false) }
    }

    fun onApellidoChange(valor: String) {
        _uiState.update { it.copy(apellido = valor, apellidoError = false) }
    }

    fun onDireccionChange(valor: String) {
        _uiState.update { it.copy(direccion = valor) }
    }

    fun onFechaNacChange(valor: String) {
        _uiState.update { it.copy(fechaNac = valor) }
    }

    fun onPagoFavChange(valor: String) {
        _uiState.update { it.copy(pagoFav = valor) }
    }

    fun toggleTerminos() {
        _uiState.update { it.copy(aceptaTerminos = !it.aceptaTerminos, terminosError = false) }
    }

    // ── Limpiar formulario (llamar al entrar a Login/Registro) ────
    fun limpiarFormulario() {
        _uiState.update { AuthUIState() }
    }
    fun iniciarSesion() {
        val state = _uiState.value

        if (state.correo.isBlank()) {
            _uiState.update { it.copy(correoError = true) }
            return
        }
        if (state.celular.isBlank()) {
            _uiState.update { it.copy(celularError = true) }
            return
        }

        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }

                val usuarios = useCase.getUsuarios()
                val encontrado = usuarios.firstOrNull {
                    it.correo.equals(state.correo.trim(), ignoreCase = true) &&
                            it.celular?.trim() == state.celular.trim()
                }

                if (encontrado != null) {
                    SessionManager.iniciarSesion(encontrado)
                    _event.emit(AuthUIEvent.NavigateToHome)
                } else {
                    _event.emit(AuthUIEvent.ShowSnackbar("Correo o celular incorrectos"))
                }

            } catch (e: Exception) {
                _event.emit(AuthUIEvent.ShowSnackbar(e.message ?: "Error al iniciar sesión"))
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun registrarse() {
        val state = _uiState.value
        var esValido = true

        if (state.nombre.isBlank()) {
            _uiState.update { it.copy(nombreError = true) }
            esValido = false
        }
        if (state.apellido.isBlank()) {
            _uiState.update { it.copy(apellidoError = true) }
            esValido = false
        }
        if (state.correo.isBlank()) {
            _uiState.update { it.copy(correoError = true) }
            esValido = false
        }
        if (state.celular.isBlank()) {
            _uiState.update { it.copy(celularError = true) }
            esValido = false
        }
        if (!state.aceptaTerminos) {
            _uiState.update { it.copy(terminosError = true) }
            esValido = false
        }
        if (!esValido) return

        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }

                // ── Verificar si el correo o celular ya están registrados ──
                val usuariosExistentes = useCase.getUsuarios()
                val yaExiste = usuariosExistentes.any {
                    it.correo.equals(state.correo.trim(), ignoreCase = true) ||
                            it.celular?.trim() == state.celular.trim()
                }

                if (yaExiste) {
                    _event.emit(AuthUIEvent.ShowSnackbar("Este usuario ya está registrado"))
                    return@launch
                }

                val nuevoUsuario = Usuario(
                    nombre = state.nombre.trim(),
                    apellido = state.apellido.trim(),
                    correo = state.correo.trim(),
                    celular = state.celular.trim(),
                    direccion = state.direccion.trim().ifBlank { null },
                    fechaNac = state.fechaNac.trim().ifBlank { null },
                    pagoFav = state.pagoFav.trim().ifBlank { null }
                )

                val creado = useCase.insertarUsuario(nuevoUsuario)
                SessionManager.iniciarSesion(creado)

                _event.emit(AuthUIEvent.NavigateToRegistroOk)

            } catch (e: Exception) {
                _event.emit(AuthUIEvent.ShowSnackbar(e.message ?: "Error al registrarse"))
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}