package com.example.visualcash.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.visualcash.presentation.components.ZetaBottomBar
import com.example.visualcash.presentation.home.screen.HomeScreen
import com.example.visualcash.presentation.navigation.BottomBarDestination
import com.example.visualcash.presentation.settings.screen.SettingsScreen

@Composable
fun MainScreen(
    onLogout: () -> Unit = {},
) {
    var selectedDestination by rememberSaveable { mutableStateOf(BottomBarDestination.HOME) }

    Scaffold(
        bottomBar = {
            ZetaBottomBar(
                selectedDestination = selectedDestination,
                onDestinationSelected = { selectedDestination = it },
                onAddClick = { },
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            when (selectedDestination) {
                BottomBarDestination.HOME -> HomeScreen()
                BottomBarDestination.MOVEMENTS -> PlaceholderScreen("Movimientos")
                BottomBarDestination.REPORTS -> PlaceholderScreen("Reportes")
                BottomBarDestination.SETTINGS -> SettingsScreen(
                    onLogoutClick = onLogout,
                )
            }
        }
    }
}

@Composable
private fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}
