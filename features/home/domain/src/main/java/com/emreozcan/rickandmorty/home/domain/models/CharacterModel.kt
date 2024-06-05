package com.emreozcan.rickandmorty.home.domain.models

/**
 * Created by @Emre Özcan on 4.06.2024
 */
data class CharacterModel(
    val name: String,
    val status: String,
    val gender: String,
    val image: String,
    val origin: String,
    val location: String,
)
