package com.example.visualcash.presentation.auth.login.state

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
)
