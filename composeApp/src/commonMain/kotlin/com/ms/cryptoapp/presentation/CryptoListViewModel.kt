package com.ms.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ms.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CryptoListViewModel(private val cryptoRepository: CryptoRepository) : ViewModel() {

    private val _state = MutableStateFlow(CryptoListState())
    val state: StateFlow<CryptoListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                val coins = cryptoRepository.getCryptoCoins()
                _state.update { it.copy(
                    isLoading = false,
                    coins = coins,
                    filteredCoins = coins
                ) }
            } catch (e: Exception) {
                _state.update { it.copy(
                    isLoading = false,
                    error = e.message ?: "An unexpected error occurred"
                ) }
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _state.update { currentState ->
            val filtered = if (query.isBlank()) {
                currentState.coins
            } else {
                currentState.coins.filter {
                    it.name.contains(query, ignoreCase = true) ||
                            it.symbol.contains(query, ignoreCase = true)
                }
            }
            currentState.copy(
                searchQuery = query,
                filteredCoins = filtered
            )
        }
    }
}
