package com.emreozcan.rickandmorty.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
)
