package com.app.cafeappv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.app.cafeappv1.presentation.navigation.Navegacion
import com.app.cafeappv1.ui.theme.CafeAppV1Theme
import com.app.cafeappv1.ui.theme.CoffeeDark

class MainActivity : ComponentActivity() {
    private val container by lazy {
        (application as CafeApplication).container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CafeAppV1Theme {

                val navController = rememberNavController()
                // Surface con fondo oscuro cubre status bar y nav bar
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CoffeeDark
                ) {
                    Navegacion(
                        navController = navController,
                        container
                    )
                }
            }
        }
    }
}
