package com.emreozcan.rickandmorty.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponseDto(
    @SerialName("info")
    val info: İnfo?,
    @SerialName("results")
    val results: List<Result?>?,
)
