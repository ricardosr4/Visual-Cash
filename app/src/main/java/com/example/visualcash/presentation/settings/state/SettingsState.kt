package com.example.visualcash.presentation.settings.state

import com.example.visualcash.core.model.Currency

data class SettingsState(
    val userName: String = "Juan Pérez",
    val userEmail: String = "juan.perez@visualcash.app",
    val membershipType: String = "Miembro Premium",
    val isDarkModeEnabled: Boolean = true,
    val selectedCurrency: Currency = Currency.DEFAULT,
    val selectedLanguage: String = "Español",
    val isNotificationsEnabled: Boolean = true,
    val appVersion: String = "V2.4.1 (BUILD 82)",
    val isCurrencySelectorVisible: Boolean = false,
)
