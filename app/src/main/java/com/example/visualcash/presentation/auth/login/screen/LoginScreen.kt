package com.example.visualcash.presentation.auth.login.screen

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.visualcash.presentation.auth.login.content.LoginContent
import com.example.visualcash.presentation.auth.login.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit = {},
    onNavigateToRegister: () -> Unit = {},
    onNavigateToForgotPassword: () -> Unit = {},
) {
    val state = viewModel.state.value

    LoginContent(
        state = state,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onPasswordVisibilityToggle = viewModel::togglePasswordVisibility,
        onLoginClick = onLoginSuccess,
        onGoogleClick = { },
        onFacebookClick = { },
        onForgotPasswordClick = onNavigateToForgotPassword,
        onRegisterClick = onNavigateToRegister,
    )
}
