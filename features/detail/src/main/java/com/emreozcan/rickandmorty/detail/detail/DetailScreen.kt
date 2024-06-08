package com.emreozcan.rickandmorty.detail.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.emreozcan.emreozcan.features.detail.domain.models.getCharacterDetailMock
import com.emreozcan.rickandmorty.detail.detail.components.CharacterDetailItem
import com.emreozcan.rickandmorty.theme.RickAndMortyTheme
import com.emreozcan.rickandmorty.theme.components.AppErrorView
import com.emreozcan.rickandmorty.theme.components.AppProgressDialog
import com.emreozcan.rickandmorty.theme.components.AppTopBar
import com.emreozcan.rickandmorty.theme.components.RickAndMortyPreview

/**
 * Created by @Emre Özcan on 8.06.2024
 */
@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    navigateUp: () -> Unit = {},
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value
    Detail(state = state, navigateUp = navigateUp)
}

@Composable
private fun Detail(
    state: DetailUiState,
    navigateUp: () -> Unit = {},
) {
    Scaffold(
        topBar = { AppTopBar(title = "Details", canNavigateBack = true, navigateUp = navigateUp) },
    ) { innerPadding ->
        when (state) {
            DetailUiState.Loading -> {
                AppProgressDialog()
            }

            is DetailUiState.RequestError -> {
                AppErrorView(message = state.message)
            }

            is DetailUiState.Success -> {
                CharacterDetailItem(character = state.characterDetail, innerPadding = innerPadding)
            }
        }
    }
}

@RickAndMortyPreview
@Composable
private fun PreviewDetailScreen() {
    RickAndMortyTheme {
        Detail(state = DetailUiState.Success(characterDetail = getCharacterDetailMock()))
    }
}
