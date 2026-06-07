package com.app.cafeappv1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.cafeappv1.presentation.screens.LoginScreen
import com.app.cafeappv1.presentation.screens.PrincipalScreen
import com.app.cafeappv1.presentation.screens.RegistroScreen
import com.app.cafeappv1.presentation.viewmodel.AuthViewModel

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    val authViewModel = remember { AuthViewModel() }

    NavHost(
        navController  = navController,
        startDestination = "principal"
    ) {
        composable("principal") {
            PrincipalScreen(
                onIniciarSesion = { navController.navigate("login") },
                onRegistrarse   = { navController.navigate("registro") }
            )
        }

        composable("login") {
            LoginScreen(
                vm             = authViewModel,
                onLoginExitoso = { navController.navigate("home") },   // TODO: HomeScreen
                onIrARegistro  = {
                    navController.navigate("registro") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("registro") {
            RegistroScreen(
                vm                = authViewModel,
                onRegistroExitoso = { navController.navigate("login") {
                    popUpTo("registro") { inclusive = true }
                }},
                onIrALogin = {
                    navController.navigate("login") {
                        popUpTo("registro") { inclusive = true }
                    }
                }
            )
        }

        // composable("home") { HomeScreen(...) }
    }
}
