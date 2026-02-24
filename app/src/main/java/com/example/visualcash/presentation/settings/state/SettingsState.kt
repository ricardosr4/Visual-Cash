package com.example.visualcash.presentation.settings.state

data class SettingsState(
    val userName: String = "Juan Pérez",
    val userEmail: String = "juan.perez@visualcash.app",
    val membershipType: String = "Miembro Premium",
    val isDarkModeEnabled: Boolean = true,
    val selectedCurrency: String = "USD ($)",
    val selectedLanguage: String = "Español",
    val isNotificationsEnabled: Boolean = true,
    val appVersion: String = "V2.4.1 (BUILD 82)",
)
