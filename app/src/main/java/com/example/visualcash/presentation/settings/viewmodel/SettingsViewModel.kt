package com.example.visualcash.presentation.settings.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.visualcash.presentation.settings.state.SettingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(SettingsState())
    val state: State<SettingsState> get() = _state

    fun toggleDarkMode(enabled: Boolean) {
        _state.value = _state.value.copy(isDarkModeEnabled = enabled)
    }
}
