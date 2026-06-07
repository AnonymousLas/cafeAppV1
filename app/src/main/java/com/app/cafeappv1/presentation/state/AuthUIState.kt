package com.app.cafeappv1.presentation.state

data class AuthUIState(
    // ── Campos compartidos login / registro ───────────────────────
    val correo             : String  = "",
    val contrasena         : String  = "",
    val correoError        : Boolean = false,
    val contrasenaError    : Boolean = false,
    val isLoading          : Boolean = false,
    val mostrarContrasena  : Boolean = false,

    // ── Campos exclusivos de registro ────────────────────────────
    val aceptaTerminos     : Boolean = false,
    val terminosError      : Boolean = false
)
