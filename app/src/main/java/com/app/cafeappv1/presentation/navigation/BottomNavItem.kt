package com.app.cafeappv1.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val ruta: String,val titulo: String,val icono: ImageVector) {
    data object Inicio : BottomNavItem(NavRutas.INICIO,"Inicio", Icons.Default.Home)
    data object Menu : BottomNavItem(NavRutas.MENU, "Menu", Icons.Default.Menu)
    data object Pedidos : BottomNavItem(NavRutas.PEDIDOS, "Pedidos", Icons.Default.ShoppingCart)
    data object  Perfil : BottomNavItem(NavRutas.PERFIL, "Perfil", Icons.Default.Person)
}