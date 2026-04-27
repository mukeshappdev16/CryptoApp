package com.ms.cryptoapp.domain.modal

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val symbol: String,
    val rank: Int
)
