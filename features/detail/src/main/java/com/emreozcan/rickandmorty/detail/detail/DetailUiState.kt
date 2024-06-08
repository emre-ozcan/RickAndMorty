package com.emreozcan.rickandmorty.detail.detail

import com.emreozcan.emreozcan.features.detail.domain.models.CharacterDetailModel

/**
 * Created by @Emre Özcan on 8.06.2024
 */
sealed class DetailUiState {
    data object Loading : DetailUiState()

    data class RequestError(val message: String) : DetailUiState()

    data class Success(val characterDetail: CharacterDetailModel) : DetailUiState()
}
