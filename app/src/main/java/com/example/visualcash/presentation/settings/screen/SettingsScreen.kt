package com.example.visualcash.presentation.settings.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visualcash.presentation.settings.content.SettingsContent
import com.example.visualcash.presentation.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = viewModel(),
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
        onCurrencyClick = { },
        onLanguageClick = { },
        onDarkModeToggle = viewModel::toggleDarkMode,
        onHelpCenterClick = { },
        onContactClick = { },
        onLogoutClick = onLogoutClick,
    )
}
