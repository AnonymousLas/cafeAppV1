package com.app.cafeappv1.presentation.event


interface UIEvent {
    data class Success(val mensaje: String): UIEvent
    data class Error(val mensaje: String): UIEvent
    data class Warning(val mensaje: String): UIEvent
}