package com.example.visualcash.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomBarDestination(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector,
) {
    HOME("Inicio", Icons.Outlined.Home, Icons.Filled.Home),
    MOVEMENTS("Movimientos", Icons.Outlined.Receipt, Icons.Filled.Receipt),
    REPORTS("Reportes", Icons.Outlined.BarChart, Icons.Filled.BarChart),
    SETTINGS("Ajustes", Icons.Outlined.Settings, Icons.Filled.Settings),
}
