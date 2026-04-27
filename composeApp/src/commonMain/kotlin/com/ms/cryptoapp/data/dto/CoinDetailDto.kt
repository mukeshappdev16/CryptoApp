package com.ms.cryptoapp.data.dto

import com.ms.cryptoapp.domain.modal.CoinDetail
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailDto(
    val description: String? = null,
    val development_status: String? = null,
    val first_data_at: String? = null,
    val hardware_wallet: Boolean? = null,
    val hash_algorithm: String? = null,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String? = null,
    val logo: String? = null,
    val message: String? = null,
    val name: String,
    val open_source: Boolean? = null,
    val org_structure: String? = null,
    val proof_type: String? = null,
    val rank: Int,
    val started_at: String? = null,
    val symbol: String,
    val team: List<Team>? = null,
    val type: String
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        description = description ?: "",
        id = id,
        isActive = is_active,
        logo = logo ?: "",
        message = message ?: "",
        name = name,
        rank = rank,
        symbol = symbol,
        team = team ?: emptyList(),
        type = type
    )
}
