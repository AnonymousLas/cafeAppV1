package com.app.cafeappv1.presentation.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.presentation.components.CoffeeCupLogo
import com.app.cafeappv1.ui.theme.CoffeeDark
import com.app.cafeappv1.ui.theme.CoffeeGold
import com.app.cafeappv1.ui.theme.CoffeeText

@Composable
fun PrincipalScreen(
    onIniciarSesion: () -> Unit,
    onRegistrarse: () -> Unit
) {
    // Animación suave de pulso para el logo
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue  = 1.04f,
        animationSpec = infiniteRepeatable(
            animation  = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "logoScale"
    )
    val steamAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue  = 0.9f,
        animationSpec = infiniteRepeatable(
            animation  = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "steamAlpha"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
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
                .padding(horizontal = 32.dp, vertical = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {

            // ── LOGO + VAPOR ──────────────────────────────────────
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .scale(pulseScale),
                    contentAlignment = Alignment.Center
                ) {
                    CoffeeCupLogo(steamAlpha = steamAlpha)
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Nombre de la marca
                Text(
                    text = "Coffee",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = CoffeeGold,
                    letterSpacing = 2.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                // ── TAGLINE ───────────────────────────────────────────
                Text(
                    text = "Tu Café Favorito,",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                    color = CoffeeText,
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.sp,
                    lineHeight = 36.sp
                )
                Text(
                    text = "En Un Clic",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = CoffeeGold,
                    textAlign = TextAlign.Center,
                    letterSpacing = 2.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // ── BOTONES ───────────────────────────────────────────
            Column(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Botón Registrarse
                OutlinedButton(
                    onClick = onRegistrarse,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = CoffeeGold
                    ),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, CoffeeGold)
                ) {
                    Text(
                        text = "Registrarse",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                // Botón Iniciar sesión
                Button(
                    onClick = onIniciarSesion,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CoffeeGold,
                        contentColor   = CoffeeDark
                    )
                ) {
                    Text(
                        text = "Iniciar sesión",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}