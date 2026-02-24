package com.example.visualcash.presentation.auth.login.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visualcash.presentation.auth.login.content.LoginContent
import com.example.visualcash.presentation.auth.login.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onNavigateToRegister: () -> Unit = {},
    onNavigateToForgotPassword: () -> Unit = {},
) {
    val state = viewModel.state.value

    LoginContent(
        state = state,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onPasswordVisibilityToggle = viewModel::togglePasswordVisibility,
        onLoginClick = { },
        onGoogleClick = { },
        onFacebookClick = { },
        onForgotPasswordClick = onNavigateToForgotPassword,
        onRegisterClick = onNavigateToRegister,
    )
}
