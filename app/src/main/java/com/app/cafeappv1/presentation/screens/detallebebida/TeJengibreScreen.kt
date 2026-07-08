package com.app.cafeappv1.presentation.screens.detallebebida

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.R

@Composable
fun TeJengibreScreen(onVolver: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF11131A))
            .systemBarsPadding()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        // BOTON VOLVER
        Text(
            text = "< Bebidas",
            color = Color(0xFFFFC107),
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { onVolver() }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // TITULO
        Text(
            text = "Té de Jengibre",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        // IMAGEN
        Image(
            painter = painterResource(id = R.drawable.tejengibre),
            contentDescription = "Te de Jengibre",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        // DESCRIPCION
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF232733), RoundedCornerShape(18.dp))
                .padding(20.dp)
        ) {
            Text(
                text = "Siente el poder natural de nuestro Té de Jengibre, una infusión con un toque picante y cítrico único.\n" +
                        "Es excelente para fortalecer tus defensas, activar tu metabolismo y reconfortar el cuerpo desde adentro.\n" +
                        "Una bebida vibrante y llena de vitalidad que despertará todos tus sentidos con cada sorbo caliente.",
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // BOTON ORDENAR
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
        ) {
            Text(
                text = "Ordenar",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

