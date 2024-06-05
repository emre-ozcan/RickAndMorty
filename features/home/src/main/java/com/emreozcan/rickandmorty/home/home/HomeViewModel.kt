package com.emreozcan.rickandmorty.home.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreozcan.rickandmorty.common.domain.models.Resource
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
        private val _uiState = MutableStateFlow(HomeState())
        val uiState: StateFlow<HomeState> = _uiState

        init {
            getCharacters()
        }

        private fun getCharacters() =
            viewModelScope.launch {
                when (val result = characterUseCase.invoke()) {
                    is Resource.Error -> {
                        _uiState.value = HomeState(errorMessage = result.e.name)
                    }
                    is Resource.Success -> {
                        _uiState.value = HomeState(characterList = result.result)
                    }
                }
            }
    }
