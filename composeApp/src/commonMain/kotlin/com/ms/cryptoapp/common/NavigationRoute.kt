package com.ms.cryptoapp.common

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
data class DetailRoute(val coinId: String)

@Serializable
object InfoRoute
