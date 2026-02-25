package com.example.visualcash.presentation.auth.register.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.visualcash.presentation.auth.register.state.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> get() = _state

    fun onFullNameChanged(fullName: String) {
        _state.value = _state.value.copy(fullName = fullName)
    }

    fun onEmailChanged(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        _state.value = _state.value.copy(confirmPassword = confirmPassword)
    }

    fun togglePasswordVisibility() {
        _state.value = _state.value.copy(
            isPasswordVisible = !_state.value.isPasswordVisible
        )
    }

    fun toggleConfirmPasswordVisibility() {
        _state.value = _state.value.copy(
            isConfirmPasswordVisible = !_state.value.isConfirmPasswordVisible
        )
    }

    fun onTermsAcceptedChanged(accepted: Boolean) {
        _state.value = _state.value.copy(isTermsAccepted = accepted)
    }
}
