package com.app.cafeappv1.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmacionScreen(
    onSeguirComprando: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF11131A))
            .systemBarsPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Orden\nConfirmada",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 38.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(25.dp))

        Box(
            modifier = Modifier
                .size(90.dp)
                .background(Color(0xFF5C9448), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Orden confirmada",
                tint = Color.Black,
                modifier = Modifier.size(55.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Gracias por su compra.",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Tu número de pedido es #123123123123.\nSe ha enviado un correo electrónico de\nconfirmación con los detalles de tu pedido.",
            color = Color.LightGray,
            fontSize = 13.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = { onSeguirComprando() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFC107),
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Seguir comprando",
                fontWeight = FontWeight.Bold
            )
        }
    }
}