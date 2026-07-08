package com.app.cafeappv1.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.cafeappv1.presentation.navigation.BottomNavItem

@Composable
fun AppBottomBar(navController: NavHostController){
    val opciones = listOf(
        BottomNavItem.Inicio,
        BottomNavItem.Menu,
        BottomNavItem.Pedidos,
        BottomNavItem.Perfil
    )
    NavigationBar(
        containerColor = Color(0xFF000000)
    ){
        val rutaActual = navController.currentBackStackEntryAsState().value?.destination?.route
        opciones.forEach { item ->
            NavigationBarItem(
                selected = rutaActual == item.ruta,
                onClick = {navController.navigate(item.ruta)},
                icon = {Icon(item.icono,null)},
                label = {Text(item.titulo)},
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF000000),
                    unselectedIconColor = Color(0xFFFFFFFF),
                    selectedTextColor = Color(0xFFFFC107),
                    unselectedTextColor = Color(0xFFFFFFFF),
                    indicatorColor = Color(0xFFFFC107)
                )
            )
        }
    }
}