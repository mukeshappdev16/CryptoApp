package com.ms.cryptoapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: String,
    val name: String,
    val position: String
)