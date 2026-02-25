package com.example.visualcash.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.visualcash.presentation.auth.login.screen.LoginScreen
import com.example.visualcash.presentation.auth.register.screen.RegisterScreen
import com.example.visualcash.presentation.main.MainScreen

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.Login)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {
            entry<Routes.Login> {
                LoginScreen(
                    onLoginSuccess = {
                        backStack.navigateAndClear(Routes.Main)
                    },
                    onNavigateToRegister = {
                        backStack.navigateTo(Routes.Register)
                    },
                    onNavigateToForgotPassword = { },
                )
            }

            entry<Routes.Register> {
                RegisterScreen(
                    onRegisterSuccess = {
                        backStack.navigateAndClear(Routes.Main)
                    },
                    onNavigateToLogin = {
                        backStack.back()
                    },
                    onNavigateBack = {
                        backStack.back()
                    },
                )
            }

            entry<Routes.Main> {
                MainScreen(
                    onLogout = {
                        backStack.navigateAndClear(Routes.Login)
                    },
                )
            }
        },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300),
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300),
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300),
            )
        },
    )
}
