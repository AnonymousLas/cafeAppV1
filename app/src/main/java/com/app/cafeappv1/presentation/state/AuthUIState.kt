package com.app.cafeappv1.presentation.state

data class AuthUIState(
    // ── Campos compartidos login / registro ───────────────────────
    val correo          : String  = "",
    val celular          : String  = "", // en login funciona como "contraseña"
    val correoError     : Boolean = false,
    val celularError     : Boolean = false,
    val isLoading       : Boolean = false,
    val mostrarCelular  : Boolean = false,

    // ── Campos exclusivos de registro ────────────────────────────
    val nombre           : String  = "",
    val apellido         : String  = "",
    val direccion        : String  = "",
    val fechaNac         : String  = "",
    val pagoFav          : String  = "",
    val nombreError      : Boolean = false,
    val apellidoError    : Boolean = false,
    val aceptaTerminos  : Boolean = false,
    val terminosError   : Boolean = false
)