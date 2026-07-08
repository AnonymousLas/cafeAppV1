package com.app.cafeappv1.presentation.navigation

object NavRutas {
    const val INICIO = "inicio"
    const val MENU = "menu"
    const val PEDIDOS = "pedidos"
    const val PERFIL = "perfil"

    fun getTitulo(ruta: String?): String{
        return when{
            ruta == INICIO -> "Inicio"
            ruta == MENU -> "Menu"
            ruta == PEDIDOS -> "Pedidos"
            ruta == PERFIL -> "Perfil"
            else -> "Inicio"
        }
    }
}