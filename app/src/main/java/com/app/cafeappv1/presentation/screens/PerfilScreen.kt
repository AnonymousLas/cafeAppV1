package com.app.cafeappv1.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.R
import com.app.cafeappv1.domain.session.SessionManager
import com.app.cafeappv1.ui.theme.CoffeeDark
import com.app.cafeappv1.ui.theme.CoffeeGold
import com.app.cafeappv1.ui.theme.CoffeeMuted
import com.app.cafeappv1.ui.theme.CoffeeSurface
import com.app.cafeappv1.ui.theme.CoffeeText
import androidx.compose.ui.graphics.Color

@Composable
fun PerfilScreen(

    onDatosPersonales: () -> Unit = {},
    onMetodosPago: () -> Unit = {},
    onConfiguracion: () -> Unit = {},
    onCerrarSesion: () -> Unit = {}
) {

    val usuario by SessionManager.usuarioActual.collectAsState()

    val nombreCompleto = if (usuario != null)
        "${usuario!!.nombre} ${usuario!!.apellido}".trim()
    else
        "Invitado"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        CoffeeDark,
                        Color(0xFF1F1500)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 28.dp)
                .padding(bottom = 100.dp)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Perfil",
                    color = CoffeeMuted,
                    fontSize = 14.sp,
                    letterSpacing = 2.sp
                )

                if (usuario != null) {
                    IconButton(onClick = onCerrarSesion) {
                        Icon(
                            imageVector = Icons.Filled.Logout,
                            contentDescription = "Cerrar sesión",
                            tint = CoffeeGold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(R.drawable.perfil),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = nombreCompleto,
                    color = CoffeeText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                if (usuario != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = usuario!!.correo,
                        color = CoffeeMuted,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (usuario != null) {
                DatoPerfil(etiqueta = "Correo", valor = usuario!!.correo)
                DatoPerfil(etiqueta = "Celular", valor = usuario!!.celular ?: "—")
                DatoPerfil(etiqueta = "Dirección", valor = usuario!!.direccion ?: "—")
                DatoPerfil(etiqueta = "Fecha de nacimiento", valor = usuario!!.fechaNac ?: "—")
                DatoPerfil(etiqueta = "Método de pago favorito", valor = usuario!!.pagoFav ?: "—")

                Spacer(modifier = Modifier.height(24.dp))
            } else {
                Text(
                    text = "No hay una sesión activa. Inicia sesión para ver tus datos.",
                    color = CoffeeMuted,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
            }

            PerfilItem(
                titulo = "Datos personales",
                onClick = onDatosPersonales
            )

            Spacer(modifier = Modifier.height(16.dp))

            PerfilItem(
                titulo = "Métodos de pago",
                onClick = onMetodosPago
            )

            Spacer(modifier = Modifier.height(16.dp))

            PerfilItem(
                titulo = "Configuración",
                onClick = onConfiguracion
            )
        }
    }
}

@Composable
private fun DatoPerfil(etiqueta: String, valor: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(
            text = etiqueta,
            color = CoffeeMuted,
            fontSize = 12.sp,
            letterSpacing = 0.5.sp
        )
        Text(
            text = valor,
            color = CoffeeText,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun PerfilItem(

    titulo: String,

    onClick: () -> Unit

) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClick() },

        shape = RoundedCornerShape(12.dp),

        colors = CardDefaults.cardColors(
            containerColor = CoffeeSurface
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp),

            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = titulo,
                color = CoffeeText,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = CoffeeGold
            )
        }
    }
}