package com.ms.cryptoapp.presentation

import com.ms.cryptoapp.domain.modal.Coin

data class CryptoListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val filteredCoins: List<Coin> = emptyList(),
    val searchQuery: String = "",
    val error: String = ""
)
