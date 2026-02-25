package com.example.visualcash.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Encapsula todas las operaciones de lectura y escritura con DataStore.
 *
 * - Lectura: cada función devuelve un Flow<T> que emite el valor actual
 *   y cualquier cambio futuro de forma reactiva.
 * - Escritura: cada función es suspend porque escribe de forma asíncrona.
 *
 * Inyectado por Hilt como Singleton (una sola instancia en toda la app).
 *
 * ────────────────────────────────────────────────────────────────────────
 * CÓMO AGREGAR UNA NUEVA PREFERENCIA:
 *
 *   1. Crear la clave en PreferencesKeys con el tipo adecuado.
 *   2. Crear aquí una función de lectura (Flow) y una de escritura (suspend).
 *   3. Usar desde el ViewModel: inyectar DataStoreManager y llamar las funciones.
 *
 * Ejemplo completo para agregar "última fecha de sincronización":
 *
 *   // En PreferencesKeys.kt:
 *   val LAST_SYNC_DATE = stringPreferencesKey("last_sync_date")
 *
 *   // Aquí en DataStoreManager:
 *   val lastSyncDate: Flow<String>
 *       get() = read(PreferencesKeys.LAST_SYNC_DATE, "")
 *
 *   suspend fun saveLastSyncDate(date: String) {
 *       write(PreferencesKeys.LAST_SYNC_DATE, date)
 *   }
 * ────────────────────────────────────────────────────────────────────────
 */
@Singleton
class DataStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) {

    // ════════════════════════════════════════════════════════════════════
    // FUNCIONES GENÉRICAS PRIVADAS (base para todas las operaciones)
    // ════════════════════════════════════════════════════════════════════

    /**
     * Lee un valor de DataStore de forma reactiva.
     * @param key Clave tipada de PreferencesKeys
     * @param defaultValue Valor por defecto si la clave no existe
     * @return Flow que emite el valor actual y futuros cambios
     */
    private fun <T> read(key: Preferences.Key<T>, defaultValue: T): Flow<T> {
        return dataStore.data.map { preferences ->
            preferences[key] ?: defaultValue
        }
    }

    /**
     * Escribe un valor en DataStore de forma asíncrona.
     * @param key Clave tipada de PreferencesKeys
     * @param value Valor a guardar
     */
    private suspend fun <T> write(key: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    /**
     * Elimina un valor específico de DataStore.
     * @param key Clave tipada de PreferencesKeys
     */
    private suspend fun <T> remove(key: Preferences.Key<T>) {
        dataStore.edit { preferences ->
            preferences.remove(key)
        }
    }

    /**
     * Elimina TODAS las preferencias de DataStore.
     * Usar con precaución (ej: al cerrar sesión para limpiar datos del usuario).
     */
    suspend fun clearAll() {
        dataStore.edit { it.clear() }
    }

    // ════════════════════════════════════════════════════════════════════
    // SESIÓN / AUTENTICACIÓN
    // ════════════════════════════════════════════════════════════════════

    /** Flow que indica si el usuario tiene sesión activa */
    val isLoggedIn: Flow<Boolean>
        get() = read(PreferencesKeys.IS_LOGGED_IN, false)

    /** Guarda el estado de sesión del usuario */
    suspend fun saveIsLoggedIn(isLoggedIn: Boolean) {
        write(PreferencesKeys.IS_LOGGED_IN, isLoggedIn)
    }

    // ════════════════════════════════════════════════════════════════════
    // PERFIL DE USUARIO
    // ════════════════════════════════════════════════════════════════════

    /** Flow con el nombre del usuario */
    val userName: Flow<String>
        get() = read(PreferencesKeys.USER_NAME, "")

    /** Guarda el nombre del usuario */
    suspend fun saveUserName(name: String) {
        write(PreferencesKeys.USER_NAME, name)
    }

    /** Flow con el email del usuario */
    val userEmail: Flow<String>
        get() = read(PreferencesKeys.USER_EMAIL, "")

    /** Guarda el email del usuario */
    suspend fun saveUserEmail(email: String) {
        write(PreferencesKeys.USER_EMAIL, email)
    }

    // ════════════════════════════════════════════════════════════════════
    // CONFIGURACIÓN DE LA APP
    // ════════════════════════════════════════════════════════════════════

    /** Flow que indica si el modo oscuro está activado */
    val isDarkMode: Flow<Boolean>
        get() = read(PreferencesKeys.IS_DARK_MODE, true)

    /** Guarda la preferencia de modo oscuro */
    suspend fun saveIsDarkMode(enabled: Boolean) {
        write(PreferencesKeys.IS_DARK_MODE, enabled)
    }

    /** Flow con el código de la moneda seleccionada (ej: "CLP", "USD") */
    val selectedCurrencyCode: Flow<String>
        get() = read(PreferencesKeys.SELECTED_CURRENCY, "CLP")

    /** Guarda el código de la moneda seleccionada */
    suspend fun saveSelectedCurrency(currencyCode: String) {
        write(PreferencesKeys.SELECTED_CURRENCY, currencyCode)
    }

    /** Flow con el idioma seleccionado */
    val selectedLanguage: Flow<String>
        get() = read(PreferencesKeys.SELECTED_LANGUAGE, "Español")

    /** Guarda el idioma seleccionado */
    suspend fun saveSelectedLanguage(language: String) {
        write(PreferencesKeys.SELECTED_LANGUAGE, language)
    }

    /** Flow que indica si las notificaciones están activadas */
    val isNotificationsEnabled: Flow<Boolean>
        get() = read(PreferencesKeys.IS_NOTIFICATIONS_ENABLED, true)

    /** Guarda la preferencia de notificaciones */
    suspend fun saveIsNotificationsEnabled(enabled: Boolean) {
        write(PreferencesKeys.IS_NOTIFICATIONS_ENABLED, enabled)
    }

    // ════════════════════════════════════════════════════════════════════
    // AGREGAR NUEVAS PREFERENCIAS AQUÍ
    // ════════════════════════════════════════════════════════════════════
    //
    // Sigue el patrón:
    //
    // val miNuevaPreferencia: Flow<TipoDeValor>
    //     get() = read(PreferencesKeys.MI_NUEVA_CLAVE, valorPorDefecto)
    //
    // suspend fun saveMiNuevaPreferencia(value: TipoDeValor) {
    //     write(PreferencesKeys.MI_NUEVA_CLAVE, value)
    // }
}
