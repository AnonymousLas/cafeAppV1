package com.app.cafeappv1.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.cafeappv1.di.AppContainer
import com.app.cafeappv1.presentation.screens.InicioScreen
import com.app.cafeappv1.presentation.screens.LoginScreen
import com.app.cafeappv1.presentation.screens.PrincipalScreen
import com.app.cafeappv1.presentation.screens.RegistroScreen


@Composable
fun Navegacion(navController: NavHostController, container: AppContainer) {

    //val navController = rememberNavController()
    //val authViewModel = remember { AuthViewModel() }

    NavHost(
        navController = navController,
        startDestination = "principal"
    ) {
        // -------- PANTALLA PRINCIPAL --------
        composable("principal") {
            PrincipalScreen(
                onIniciarSesion = {
                    navController.navigate("login")
                },
                onRegistrarse = {
                    navController.navigate("registro")
                }
            )
        }
        // -------- LOGIN --------
        composable("login") {
            LoginScreen(
                onLoginExitoso = { navController.navigate("inicio") },   // TODO: HomeScreen
                onIrARegistro  = {
                    navController.navigate("registro") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                container = container
            )
        }

        // -------- REGISTRO --------
        composable("registro") {
            RegistroScreen(
                onRegistroExitoso = { navController.navigate("login") {
                    popUpTo("registro") { inclusive = true }
                }},
                onIrALogin = {
                    navController.navigate("login") {
                        popUpTo("registro") { inclusive = true }
                    }
                },
                container = container
            )
        }
        composable("inicio") {
            InicioScreen(
                container = container,
                navController = navController
            )
        }
    }
}