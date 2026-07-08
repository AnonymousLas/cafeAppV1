package com.app.cafeappv1.presentation.screens

import com.app.cafeappv1.presentation.screens.menu.CafeScreen
import com.app.cafeappv1.presentation.screens.menu.BebidasScreen
import com.app.cafeappv1.presentation.screens.menu.ComidaScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.graphics.Brush
import com.app.cafeappv1.presentation.viewmodel.PedidoViewModel
import com.app.cafeappv1.presentation.viewmodel.ProductoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(productoViewModel: ProductoViewModel, pedidoViewModel: PedidoViewModel) {

    var seccionActual by remember { mutableStateOf("") }

    when (seccionActual) {
        "cafes"    -> CafeScreen(onVolver = { seccionActual = ""},
            productoViewModel = productoViewModel,
            pedidoViewModel = pedidoViewModel)
        "bebidas"  -> BebidasScreen(onVolver = { seccionActual = ""},
            productoViewModel = productoViewModel,
            pedidoViewModel = pedidoViewModel)
        "comidas"  -> ComidaScreen(onVolver = {seccionActual =""},
            productoViewModel = productoViewModel,
            pedidoViewModel = pedidoViewModel)
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 80.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Menú",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                // TARJETA CAFES
                Card(
                    onClick = { seccionActual = "cafes" },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.cafes),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.45f)
                                .align(Alignment.BottomCenter)
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.15f),
                                            Color.Black.copy(alpha = 0.45f),
                                            Color.Black.copy(alpha = 0.85f)
                                        )
                                    )
                                )
                        )

                        Text(
                            text = "CAFÉS",
                            color = Color(0xFFFFFFFF),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // TARJETA BEBIDAS
                Card(
                    onClick = { seccionActual = "bebidas" },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.bebidas),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.45f)
                                .align(Alignment.BottomCenter)
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.15f),
                                            Color.Black.copy(alpha = 0.45f),
                                            Color.Black.copy(alpha = 0.85f)
                                        )
                                    )
                                )
                        )

                        Text(
                            text = "INFUSIÓN Y BEBIDAS",
                            color = Color(0xFFFFFFFF),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // TARJETA COMIDAS
                Card(
                    onClick = { seccionActual = "comidas" },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.comidas),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.45f)
                                .align(Alignment.BottomCenter)
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.15f),
                                            Color.Black.copy(alpha = 0.45f),
                                            Color.Black.copy(alpha = 0.85f)
                                        )
                                    )
                                )
                        )
                        Text(
                            text = "COMIDAS",
                            color = Color(0xFFFFFFFF),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CafeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Menú de Cafés", color = Color.White)
    }
}

@Composable
fun BebidasScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Menú de Bebidas", color = Color.White)
    }
}

@Composable
fun ComidaScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Menú de Comidas", color = Color.White)
    }
}