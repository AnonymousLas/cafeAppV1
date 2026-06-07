package com.app.cafeappv1.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.presentation.state.AuthUIEvent
import com.app.cafeappv1.presentation.viewmodel.AuthViewModel
import com.app.cafeappv1.ui.theme.CoffeeDark
import com.app.cafeappv1.ui.theme.CoffeeGold
import com.app.cafeappv1.ui.theme.CoffeeGoldDark
import com.app.cafeappv1.ui.theme.CoffeeInputBg
import com.app.cafeappv1.ui.theme.CoffeeMuted
import com.app.cafeappv1.ui.theme.CoffeeSurface
import com.app.cafeappv1.ui.theme.CoffeeText

@Composable
fun LoginScreen(
    vm: AuthViewModel,
    onLoginExitoso: () -> Unit,
    onIrARegistro: () -> Unit
) {
    val uiState by vm.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        vm.event.collect { event ->
            when (event) {
                is AuthUIEvent.ShowSnackbar   -> snackbarHostState.showSnackbar(event.mensaje)
                is AuthUIEvent.NavigateToHome -> onLoginExitoso()
                else                          -> {}
            }
        }
    }

    // Box raíz cubre TODO incluyendo barras del sistema
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(CoffeeDark, Color(0xFF1F1500))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()                          // respeta status + nav bar
                .padding(horizontal = 28.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ── ENCABEZADO ────────────────────────────────────────
            Text(
                text = "Bienvenido",
                fontSize = 14.sp,
                color = CoffeeMuted,
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Iniciar sesión",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = CoffeeText
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .size(width = 48.dp, height = 3.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(CoffeeGold, CoffeeGoldDark)
                        ),
                        shape = RoundedCornerShape(2.dp)
                    )
            )

            Spacer(modifier = Modifier.height(40.dp))

            // ── CAMPO CORREO ──────────────────────────────────────
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Correo",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = CoffeeMuted,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value         = uiState.correo,
                    onValueChange = { vm.onCorreoChange(it) },
                    placeholder   = { Text("Ingrese su correo", color = CoffeeMuted, fontSize = 14.sp) },
                    isError       = uiState.correoError,
                    supportingText = {
                        if (uiState.correoError)
                            Text("Ingrese su correo", color = CoffeeGold, fontSize = 12.sp)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    modifier   = Modifier.fillMaxWidth(),
                    shape      = RoundedCornerShape(12.dp),
                    colors     = campoColores()
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ── CAMPO CONTRASEÑA ──────────────────────────────────
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Contraseña",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = CoffeeMuted,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value         = uiState.contrasena,
                    onValueChange = { vm.onContrasenaChange(it) },
                    placeholder   = { Text("Ingrese su contraseña", color = CoffeeMuted, fontSize = 14.sp) },
                    isError       = uiState.contrasenaError,
                    supportingText = {
                        if (uiState.contrasenaError)
                            Text("Ingrese su contraseña", color = CoffeeGold, fontSize = 12.sp)
                    },
                    visualTransformation = if (uiState.mostrarContrasena)
                        VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = { vm.toggleMostrarContrasena() }) {
                            Icon(
                                imageVector = if (uiState.mostrarContrasena)
                                    Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = "Mostrar contraseña",
                                tint = CoffeeMuted
                            )
                        }
                    },
                    singleLine = true,
                    modifier   = Modifier.fillMaxWidth(),
                    shape      = RoundedCornerShape(12.dp),
                    colors     = campoColores()
                )
            }

            // ── ¿OLVIDASTE CONTRASEÑA? ────────────────────────────
            Text(
                text = "¿Olvidaste la contraseña?",
                fontSize = 13.sp,
                color = CoffeeGold,
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { }
                    .padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // ── BOTÓN ─────────────────────────────────────────────
            Button(
                onClick  = { vm.iniciarSesion() },
                enabled  = !uiState.isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape  = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor         = CoffeeGold,
                    contentColor           = CoffeeDark,
                    disabledContainerColor = CoffeeGoldDark
                )
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        color = CoffeeDark, strokeWidth = 2.dp,
                        modifier = Modifier.size(22.dp)
                    )
                } else {
                    Text("Iniciar sesión", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // ── LINK A REGISTRO ───────────────────────────────────
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("¿No tienes cuenta? ", fontSize = 14.sp, color = CoffeeMuted)
                Text(
                    text = "Regístrate",
                    fontSize = 14.sp,
                    color = CoffeeGold,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onIrARegistro() }
                )
            }
        }

        // Snackbar flotante encima de todo
        SnackbarHost(
            hostState = snackbarHostState,
            modifier  = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun campoColores() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor      = CoffeeGold,
    unfocusedBorderColor    = CoffeeSurface,
    focusedTextColor        = CoffeeText,
    unfocusedTextColor      = CoffeeText,
    cursorColor             = CoffeeGold,
    focusedContainerColor   = CoffeeInputBg,
    unfocusedContainerColor = CoffeeInputBg,
    errorBorderColor        = CoffeeGold,
    errorContainerColor     = CoffeeInputBg
)
