package com.example.visualcash.presentation.settings.screen

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.visualcash.presentation.settings.content.SettingsContent
import com.example.visualcash.presentation.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    onDoneClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
) {
    val state = viewModel.state.value

    SettingsContent(
        state = state,
        onDoneClick = onDoneClick,
        onChangePasswordClick = { },
        onSecurityClick = { },
        onNotificationsClick = { },
        onCurrencyClick = viewModel::showCurrencySelector,
        onCurrencySelected = viewModel::selectCurrency,
        onCurrencySelectorDismiss = viewModel::hideCurrencySelector,
        onLanguageClick = { },
        onDarkModeToggle = viewModel::toggleDarkMode,
        onHelpCenterClick = { },
        onContactClick = { },
        onLogoutClick = onLogoutClick,
    )
}
