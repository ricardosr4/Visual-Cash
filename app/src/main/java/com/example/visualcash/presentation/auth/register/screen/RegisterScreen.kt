package com.example.visualcash.presentation.auth.register.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visualcash.presentation.auth.register.content.RegisterContent
import com.example.visualcash.presentation.auth.register.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel(),
    onNavigateToLogin: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
) {
    val state = viewModel.state.value

    RegisterContent(
        state = state,
        onFullNameChanged = viewModel::onFullNameChanged,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onConfirmPasswordChanged = viewModel::onConfirmPasswordChanged,
        onPasswordVisibilityToggle = viewModel::togglePasswordVisibility,
        onConfirmPasswordVisibilityToggle = viewModel::toggleConfirmPasswordVisibility,
        onTermsAcceptedChanged = viewModel::onTermsAcceptedChanged,
        onRegisterClick = { },
        onGoogleClick = { },
        onFacebookClick = { },
        onBackClick = onNavigateBack,
        onHelpClick = { },
        onLoginClick = onNavigateToLogin,
    )
}
