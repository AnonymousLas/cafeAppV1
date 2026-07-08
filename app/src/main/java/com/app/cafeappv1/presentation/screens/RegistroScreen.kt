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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.di.AppContainer
import com.app.cafeappv1.presentation.state.AuthUIEvent
import com.app.cafeappv1.ui.theme.CoffeeDark
import com.app.cafeappv1.ui.theme.CoffeeGold
import com.app.cafeappv1.ui.theme.CoffeeGoldDark
import com.app.cafeappv1.ui.theme.CoffeeInputBg
import com.app.cafeappv1.ui.theme.CoffeeMuted
import com.app.cafeappv1.ui.theme.CoffeeSurface
import com.app.cafeappv1.ui.theme.CoffeeText

@Composable
fun RegistroScreen(
    container: AppContainer,
    onRegistroExitoso: () -> Unit,
    onIrALogin: () -> Unit
) {
    val vm = container.authViewModel
    val uiState by vm.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        vm.limpiarFormulario()
        vm.event.collect { event ->
            when (event) {
                is AuthUIEvent.ShowSnackbar         -> snackbarHostState.showSnackbar(event.mensaje)
                is AuthUIEvent.NavigateToRegistroOk -> onRegistroExitoso()
                else                                -> {}
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
                .systemBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 28.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Únete a nosotros",
                fontSize = 14.sp,
                color = CoffeeMuted,
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Registrarse",
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

            Spacer(modifier = Modifier.height(36.dp))

            // ── NOMBRE ──────────────────────────────────────────
            CampoTexto(
                label        = "Nombre",
                valor        = uiState.nombre,
                placeholder  = "Ingrese su nombre",
                tieneError   = uiState.nombreError,
                mensajeError = "Ingrese su nombre",
                teclado      = KeyboardOptions(keyboardType = KeyboardType.Text),
                onChange     = { vm.onNombreChange(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── APELLIDO ────────────────────────────────────────
            CampoTexto(
                label        = "Apellido",
                valor        = uiState.apellido,
                placeholder  = "Ingrese su apellido",
                tieneError   = uiState.apellidoError,
                mensajeError = "Ingrese su apellido",
                teclado      = KeyboardOptions(keyboardType = KeyboardType.Text),
                onChange     = { vm.onApellidoChange(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── CORREO ──────────────────────────────────────────
            CampoTexto(
                label        = "Correo",
                valor        = uiState.correo,
                placeholder  = "Ingrese su correo",
                tieneError   = uiState.correoError,
                mensajeError = "Ingrese un correo válido",
                teclado      = KeyboardOptions(keyboardType = KeyboardType.Email),
                onChange     = { vm.onCorreoChange(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── CELULAR (será tu "contraseña" para iniciar sesión) ─
            CampoTexto(
                label        = "Número de celular",
                valor        = uiState.celular,
                placeholder  = "Ingrese su celular",
                tieneError   = uiState.celularError,
                mensajeError = "Ingrese su celular",
                mensajeAyuda = "Lo usarás junto al correo para iniciar sesión",
                teclado      = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onChange     = { vm.onCelularChange(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── DIRECCIÓN (opcional) ──────────────────────────────
            CampoTexto(
                label        = "Dirección",
                valor        = uiState.direccion,
                placeholder  = "Ej. San Miguel, Lima",
                tieneError   = false,
                mensajeError = "",
                teclado      = KeyboardOptions(keyboardType = KeyboardType.Text),
                onChange     = { vm.onDireccionChange(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── FECHA DE NACIMIENTO (opcional) ───────────────────
            CampoTexto(
                label        = "Fecha de nacimiento",
                valor        = uiState.fechaNac,
                placeholder  = "AAAA-MM-DD",
                tieneError   = false,
                mensajeError = "",
                teclado      = KeyboardOptions(keyboardType = KeyboardType.Number),
                onChange     = { vm.onFechaNacChange(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── MÉTODO DE PAGO FAVORITO (opcional) ───────────────
            CampoTexto(
                label        = "Método de pago favorito",
                valor        = uiState.pagoFav,
                placeholder  = "Ej. Yape, Tarjeta, Efectivo",
                tieneError   = false,
                mensajeError = "",
                teclado      = KeyboardOptions(keyboardType = KeyboardType.Text),
                onChange     = { vm.onPagoFavChange(it) }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ── CHECKBOX TÉRMINOS ─────────────────────────────────
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = uiState.aceptaTerminos,
                    onCheckedChange = { vm.toggleTerminos() },
                    colors = CheckboxDefaults.colors(
                        checkedColor   = CoffeeGold,
                        uncheckedColor = CoffeeMuted,
                        checkmarkColor = CoffeeDark
                    )
                )
                Row(modifier = Modifier.padding(top = 13.dp)) {
                    Text("Aceptar los ", fontSize = 13.sp, color = CoffeeMuted)
                    Text(
                        text = "Términos de Uso",
                        fontSize = 13.sp,
                        color = CoffeeGold,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable { }
                    )
                    Text(" y la ", fontSize = 13.sp, color = CoffeeMuted)
                    Text(
                        text = "Política de Privacidad",
                        fontSize = 13.sp,
                        color = CoffeeGold,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable { }
                    )
                }
            }

            if (uiState.terminosError) {
                Text(
                    text = "Debes aceptar los términos para continuar",
                    color = CoffeeGold,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 12.dp)
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            // ── BOTÓN REGISTRARSE ─────────────────────────────────
            Button(
                onClick  = { vm.registrarse() },
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
                    Text("Registrarse", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ── LINK A LOGIN ──────────────────────────────────────
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("¿Ya tienes una cuenta? ", fontSize = 14.sp, color = CoffeeMuted)
                Text(
                    text = "¡Inicia sesión!",
                    fontSize = 14.sp,
                    color = CoffeeGold,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onIrALogin() }
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
private fun CampoTexto(
    label: String,
    valor: String,
    placeholder: String,
    tieneError: Boolean,
    mensajeError: String,
    teclado: KeyboardOptions,
    onChange: (String) -> Unit,
    mensajeAyuda: String? = null
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = CoffeeMuted,
            letterSpacing = 0.5.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value         = valor,
            onValueChange = onChange,
            placeholder   = { Text(placeholder, color = CoffeeMuted, fontSize = 14.sp) },
            isError       = tieneError,
            supportingText = {
                if (tieneError) Text(mensajeError, color = CoffeeGold, fontSize = 12.sp)
                else if (mensajeAyuda != null) Text(mensajeAyuda, color = CoffeeMuted, fontSize = 11.sp)
            },
            keyboardOptions = teclado,
            singleLine = true,
            modifier   = Modifier.fillMaxWidth(),
            shape      = RoundedCornerShape(12.dp),
            colors     = campoColores()
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