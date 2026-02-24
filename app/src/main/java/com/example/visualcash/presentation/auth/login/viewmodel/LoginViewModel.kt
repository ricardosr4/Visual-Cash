package com.example.visualcash.presentation.auth.login.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.visualcash.presentation.auth.login.state.LoginState

class LoginViewModel : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> get() = _state

    fun onEmailChanged(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun togglePasswordVisibility() {
        _state.value = _state.value.copy(
            isPasswordVisible = !_state.value.isPasswordVisible
        )
    }
}
