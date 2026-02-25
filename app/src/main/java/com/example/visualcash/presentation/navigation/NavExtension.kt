package com.example.visualcash.presentation.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

fun NavBackStack<NavKey>.navigateTo(screen: NavKey) {
    add(screen)
}

fun NavBackStack<NavKey>.back() {
    if (size <= 1) return
    removeLastOrNull()
}

fun NavBackStack<NavKey>.navigateAndClear(screen: NavKey) {
    clear()
    add(screen)
}

fun NavBackStack<NavKey>.backTo(targetScreen: NavKey) {
    while (size > 1 && lastOrNull() != targetScreen) {
        removeLastOrNull()
    }
}
