package com.example.visualcash.presentation.settings.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visualcash.core.model.Currency
import com.example.visualcash.data.local.datastore.DataStoreManager
import com.example.visualcash.presentation.settings.state.SettingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {

    private val _state = mutableStateOf(SettingsState())
    val state: State<SettingsState> get() = _state

    init {
        observeCurrency()
    }

    /**
     * Observa cambios en la moneda guardada en DataStore.
     * Cada vez que cambie, actualiza el estado de la UI automáticamente.
     */
    private fun observeCurrency() {
        dataStoreManager.selectedCurrencyCode
            .onEach { code ->
                _state.value = _state.value.copy(
                    selectedCurrency = Currency.fromCode(code),
                )
            }
            .launchIn(viewModelScope)
    }

    fun toggleDarkMode(enabled: Boolean) {
        _state.value = _state.value.copy(isDarkModeEnabled = enabled)
    }

    fun showCurrencySelector() {
        _state.value = _state.value.copy(isCurrencySelectorVisible = true)
    }

    fun hideCurrencySelector() {
        _state.value = _state.value.copy(isCurrencySelectorVisible = false)
    }

    /**
     * Guarda la moneda seleccionada en DataStore.
     * El Flow observado en observeCurrency() actualizará la UI automáticamente.
     */
    fun selectCurrency(currency: Currency) {
        viewModelScope.launch {
            dataStoreManager.saveSelectedCurrency(currency.code)
        }
        hideCurrencySelector()
    }
}
