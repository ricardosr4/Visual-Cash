package com.example.visualcash.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val VisualCashColorScheme = darkColorScheme(
    primary = ZetaBlue,
    onPrimary = Color.White,
    primaryContainer = ZetaBlueDark,
    onPrimaryContainer = Color.White,
    secondary = ZetaBlueLight,
    onSecondary = Color.White,
    background = DarkBackground,
    onBackground = TextPrimary,
    surface = DarkSurface,
    onSurface = TextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant,
    inverseSurface = Color.White,
    inverseOnSurface = DarkBackground,
    error = Color(0xFFEF4444),
    onError = Color.White,
)

@Composable
fun VisualCashTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = VisualCashColorScheme,
        typography = Typography,
        content = content
    )
}
