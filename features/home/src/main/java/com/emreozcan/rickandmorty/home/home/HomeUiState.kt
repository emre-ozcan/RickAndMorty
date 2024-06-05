package com.emreozcan.rickandmorty.home.home

import com.emreozcan.rickandmorty.home.domain.models.CharacterModel

/**
 * Created by @Emre Özcan on 4.06.2024
 */
sealed class HomeUiState {
    data object Loading : HomeUiState()

    data class RequestError(val message: String) : HomeUiState()

    data class Success(val characterList: List<CharacterModel>) : HomeUiState()
}
