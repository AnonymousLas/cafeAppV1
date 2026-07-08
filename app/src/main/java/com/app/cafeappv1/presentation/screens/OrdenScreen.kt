package com.app.cafeappv1.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.R
import com.app.cafeappv1.domain.model.Pedido
import com.app.cafeappv1.domain.model.Producto

@Composable
fun OrdenScreen(
    producto: Producto,
    onVolver: () -> Unit,
    onPagar: (Pedido) -> Unit
) {
    var cantidad by remember { mutableStateOf(1) }

    val total = cantidad * producto.precio

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF11131A))
            .systemBarsPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "< Volver",
            color = Color(0xFFFFC107),
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { onVolver() }
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Detalle del pedido",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = producto.imagen),
            contentDescription = producto.nombre,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = producto.nombre,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Precio: S/ ${String.format("%.2f", producto.precio)}",
            color = Color.LightGray,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = "Stock disponible: ${producto.stock}",
            color = Color.LightGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Cantidad",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    if (cantidad > 1) cantidad--
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFC107),
                    contentColor = Color.Black
                )
            ) {
                Text("-")
            }

            Text(
                text = "$cantidad",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 25.dp)
            )

            Button(
                onClick = {
                    if(cantidad < producto.stock)
                        cantidad++
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFC107),
                    contentColor = Color.Black
                )
            ) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(35.dp))

        var metodoPago by remember { mutableStateOf("Tarjeta") }

        Text(
            text = "Método de pago",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box {

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf("Tarjeta", "Yape/Plin", "Efectivo").forEach { metodo ->
                    Button(
                        onClick = { metodoPago = metodo },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (metodoPago == metodo) Color(0xFFFFC107) else Color(0xFF2A2D36),
                            contentColor = if (metodoPago == metodo) Color.Black else Color.White
                        )
                    ) {
                        Text(
                            text = metodo,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Total: S/ ${String.format("%.2f", total)}",
            color = Color(0xFFFFC107),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                val pedido = Pedido(
                    idPedido = System.currentTimeMillis().toString(),
                    idProducto = producto.id.toString(),
                    productoNombre = producto.nombre,
                    cantidad = cantidad,
                    metodoPago = metodoPago,
                    total = total,
                    fecha = "2026-07-08"
                )
                onPagar(pedido)

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFC107),
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Pagar",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}