package com.app.cafeappv1.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val CoffeeColorScheme = darkColorScheme(
    primary          = CoffeeGold,
    onPrimary        = CoffeeDark,
    secondary        = CoffeeBrown,
    onSecondary      = CoffeeText,
    background       = CoffeeDark,
    onBackground     = CoffeeText,
    surface          = CoffeeSurface,
    onSurface        = CoffeeText,
    surfaceVariant   = CoffeeSurface2,
    onSurfaceVariant = CoffeeMuted,
    outline          = CoffeeBorder
)

@Composable
fun CafeAppV1Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CoffeeColorScheme,
        content = content
    )
}
