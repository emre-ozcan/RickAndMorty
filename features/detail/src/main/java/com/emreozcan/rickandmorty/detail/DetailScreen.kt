package com.emreozcan.rickandmorty.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.emreozcan.rickandmorty.theme.RickAndMortyTheme
import com.emreozcan.rickandmorty.theme.components.AppTopBar
import com.emreozcan.rickandmorty.theme.components.RickAndMortyPreview

/**
 * Created by @Emre Özcan on 8.06.2024
 */
@Composable
fun DetailScreen(navigateUp: () -> Unit = {},) {
    Detail(navigateUp = navigateUp)
}

@Composable
private fun Detail(navigateUp: () -> Unit = {}) {
    Scaffold(
        topBar = { AppTopBar(title = "Details", canNavigateBack = true, navigateUp = navigateUp) },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}

@RickAndMortyPreview
@Composable
private fun PreviewDetailScreen() {
    RickAndMortyTheme {
        Detail()
    }
}
