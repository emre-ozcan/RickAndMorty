package com.emreozcan.rickandmorty.home.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.emreozcan.rickandmorty.theme.RickAndMortyTheme
import com.emreozcan.rickandmorty.theme.components.RickAndMortyPreview

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value

    Home(state)
}

@Composable
fun Home(state: HomeState) {
    Text(text = "Home Screen")
}

@RickAndMortyPreview
@Composable
fun PreviewHomeScreen() {
    RickAndMortyTheme {
        Home(HomeState())
    }
}
