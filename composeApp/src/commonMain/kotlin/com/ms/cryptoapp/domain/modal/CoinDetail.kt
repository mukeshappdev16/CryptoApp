package com.ms.cryptoapp.domain.modal

import com.ms.cryptoapp.data.dto.Links
import com.ms.cryptoapp.data.dto.Tag
import com.ms.cryptoapp.data.dto.Team

data class CoinDetail(
    val description: String,
    val id: String,
    val isActive: Boolean,
    val links: Links,
    val logo: String,
    val message: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String
)

