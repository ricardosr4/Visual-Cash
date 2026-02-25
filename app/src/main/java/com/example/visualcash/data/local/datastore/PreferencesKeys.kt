package com.example.visualcash.data.local.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

/**
 * Claves tipadas para DataStore Preferences.
 *
 * Cada clave define el nombre y tipo del valor que se almacena.
 * Usar estas constantes en DataStoreManager para leer y escribir preferencias.
 *
 * Tipos disponibles:
 *   - stringPreferencesKey("nombre")   → String
 *   - booleanPreferencesKey("nombre")  → Boolean
 *   - intPreferencesKey("nombre")      → Int
 *   - longPreferencesKey("nombre")     → Long
 *   - floatPreferencesKey("nombre")    → Float
 *   - doublePreferencesKey("nombre")   → Double
 *   - stringSetPreferencesKey("nombre") → Set<String>
 *
 * Para agregar una nueva preferencia:
 *   1. Crear la clave aquí con el tipo adecuado.
 *   2. Crear las funciones de lectura y escritura en DataStoreManager.
 */
object PreferencesKeys {

    // ─── Sesión / Autenticación ─────────────────────────────────────────
    // Indica si el usuario ya inició sesión (para decidir pantalla inicial)
    val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")

    // ─── Perfil de usuario ──────────────────────────────────────────────
    // Nombre completo del usuario autenticado
    val USER_NAME = stringPreferencesKey("user_name")

    // Correo electrónico del usuario autenticado
    val USER_EMAIL = stringPreferencesKey("user_email")

    // ─── Configuración de la app ────────────────────────────────────────
    // Tema oscuro activado/desactivado
    val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")

    // Moneda seleccionada (ej: "USD ($)", "EUR (€)")
    val SELECTED_CURRENCY = stringPreferencesKey("selected_currency")

    // Idioma seleccionado (ej: "Español", "English")
    val SELECTED_LANGUAGE = stringPreferencesKey("selected_language")

    // Notificaciones activadas/desactivadas
    val IS_NOTIFICATIONS_ENABLED = booleanPreferencesKey("is_notifications_enabled")

    // ─── Agregar nuevas claves aquí ─────────────────────────────────────
    // val MI_NUEVA_CLAVE = stringPreferencesKey("mi_nueva_clave")
}
