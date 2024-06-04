package com.emreozcan.rickandmorty.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@Serializable
data class DefaultError(
    @SerialName("error")
    val error: String,
)