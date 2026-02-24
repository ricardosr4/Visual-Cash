package com.example.visualcash.presentation.settings.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.visualcash.presentation.settings.state.SettingsState

class SettingsViewModel : ViewModel() {

    private val _state = mutableStateOf(SettingsState())
    val state: State<SettingsState> get() = _state

    fun toggleDarkMode(enabled: Boolean) {
        _state.value = _state.value.copy(isDarkModeEnabled = enabled)
    }
}
