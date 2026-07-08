package com.app.cafeappv1.presentation.screens.detallecomida

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
fun Triple_polloScreen(onVolver: () -> Unit,
                       onOrdenar: () -> Unit) {

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
            text = "< Comidas",
            color = Color(0xFFFFC107),
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { onVolver() }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // TITULO
        Text(
            text = "Triple de Pollo",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        // IMAGEN
        Image(
            painter = painterResource(id = R.drawable.triple_pollo),
            contentDescription = "Triple de Pollo",
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
                text = "Un clásico infaltable con tres capas de puro sabor, frescura y la textura perfecta.\n" +
                        "Preparado con pollo deshilachado, palta cremosa y huevo, todo en un pan de molde suave y tierno.\n" +
                        "La opción ligera, equilibrada e ideal para un antojo rápido a cualquier hora del día.",
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // BOTON ORDENAR
        Button(
            onClick = { onOrdenar()},
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