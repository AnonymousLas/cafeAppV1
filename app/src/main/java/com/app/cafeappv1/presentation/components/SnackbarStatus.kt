package com.app.cafeappv1.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

//Clase enumerada (lista de opciones)
enum class SnackbarStatus(
    val backgroundColor: Color,
    val textColor: Color,
    val icono: ImageVector,
    val iconoDesc: String
) {
    SUCCESS(
        Color(0xFF5FE165),
        Color(0xFF000000),
        Icons.Default.Check,
        ""
    ),

    ERROR(
        Color(0xFFD32F2F),
        Color(0xFFFFFFFF),
        Icons.Default.Error,
        ""
    ),

    WARNING(
        Color(0xFFFBC02D),
        Color(0xFF000000),
        Icons.Default.Warning,
        ""
    )
}