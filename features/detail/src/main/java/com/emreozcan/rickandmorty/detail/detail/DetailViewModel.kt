package com.emreozcan.rickandmorty.detail.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreozcan.emreozcan.features.detail.domain.usecases.CharacterDetailUseCase
import com.emreozcan.rickandmorty.common.domain.models.Resource
import com.emreozcan.rickandmorty.common.domain.models.getError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 8.06.2024
 */
@HiltViewModel
class DetailViewModel
    @Inject
    constructor(
        savedStateHandle: SavedStateHandle,
        private val characterDetailUseCase: CharacterDetailUseCase,
    ) : ViewModel() {
        private val characterId: String = checkNotNull(savedStateHandle["characterId"])

        private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
        val uiState = _uiState.asStateFlow()

        init {
            getCharacterDetail(characterId = characterId)
        }

        private fun getCharacterDetail(characterId: String) =
            viewModelScope.launch {
                when (val result = characterDetailUseCase.invoke(characterId = characterId)) {
                    is Resource.Error ->
                        _uiState.value =
                            DetailUiState.RequestError(message = getError(result))
                    is Resource.Success ->
                        _uiState.value =
                            DetailUiState.Success(characterDetail = result.result)
                }
            }
    }
