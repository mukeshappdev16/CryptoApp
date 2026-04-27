package com.ms.cryptoapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Whitepaper(
    val link: String,
    val thumbnail: String
)