package com.app.cafeappv1.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.presentation.viewmodel.PedidoViewModel

@Composable
fun PedidosScreen(
    pedidoViewModel: PedidoViewModel
) {

    val pedidos by pedidoViewModel.pedidos.collectAsState()

    LaunchedEffect(Unit) {
        pedidoViewModel.cargarPedidos()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF11131A))
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Mis pedidos",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(pedidos) { pedido ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {

                        Text(
                            text = pedido.productoNombre,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Cantidad: ${pedido.cantidad}"
                        )

                        Text(
                            text = "Pago: ${pedido.metodoPago}"
                        )

                        Text(
                            text = "Total: S/ ${pedido.total}"
                        )

                        Text(
                            text = "Fecha: ${pedido.fecha}"
                        )
                    }
                }
            }
        }
    }
}