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
fun JugoPapayaScreen(onVolver: () -> Unit) {

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
            text = "Jugo de Papaya",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        // IMAGEN
        Image(
            painter = painterResource(id = R.drawable.papaya1),
            contentDescription = "Jugo de Papaya",
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
                text = "Arranca tu mañana con la energía y suavidad de nuestro Jugo de Papaya, recién hecho y lleno de vida.\n" +
                        "Su textura cremosa y dulzura natural lo convierten en una opción deliciosa, ligera y muy digestiva.\n" +
                        "Una bebida clásica, sumamente nutritiva y refrescante que a todo el mundo le encanta disfrutar.",
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

