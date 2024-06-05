package com.emreozcan.rickandmorty.home.home

import com.emreozcan.rickandmorty.home.domain.models.CharacterModel

/**
 * Created by @Emre Özcan on 4.06.2024
 */
data class HomeState(
    val isLoading: Boolean = false,
    val characterList: List<CharacterModel> = emptyList(),
    val errorMessage: String = "",
)
