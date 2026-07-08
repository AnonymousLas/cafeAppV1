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
fun ChocolateScreen(onVolver: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF11131A))
            .systemBarsPadding()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        // boton volver
        Text(
            text = "< Bebidas",
            color = Color(0xFFFFC107),
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { onVolver() }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // titulo
        Text(
            text = "Chocolate",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        // IMAGEN
        Image(
            painter = painterResource(id = R.drawable.chocolate),
            contentDescription = "Chocolate",
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
                text = "Ríndete a la tentación de nuestro delicioso Chocolate caliente, de textura cremosa y un sabor muy denso.\n" +
                        "Preparado con insumos seleccionados para garantizar ese toque dulce y reconfortante que tanto te gusta.\n" +
                        "Ideal para los días fríos, para compartir en buena compañía o simplemente para consentirte como mereces.",
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

