package com.emreozcan.rickandmorty.home.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreozcan.rickandmorty.common.domain.models.Resource
import com.emreozcan.rickandmorty.common.domain.models.getError
import com.emreozcan.rickandmorty.home.domain.usecases.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val characterUseCase: CharacterUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Success(emptyList()))
        val uiState: StateFlow<HomeUiState> = _uiState

        init {
            getCharacters()
        }

        private fun getCharacters() =
            viewModelScope.launch {
                _uiState.value = HomeUiState.Loading
                when (val result = characterUseCase.invoke()) {
                    is Resource.Error -> {
                        _uiState.value = HomeUiState.RequestError(message = getError(result))
                    }
                    is Resource.Success -> {
                        _uiState.value = HomeUiState.Success(characterList = result.result)
                    }
                }
            }
    }
