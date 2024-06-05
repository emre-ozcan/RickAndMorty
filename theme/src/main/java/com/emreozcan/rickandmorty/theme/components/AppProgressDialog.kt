package com.emreozcan.rickandmorty.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.emreozcan.rickandmorty.theme.RickAndMortyTheme

/**
 * Created by @Emre Özcan on 5.06.2024
 */
@Composable
fun AppProgressDialog() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@RickAndMortyPreview
@Composable
fun PreviewAppProgressDialog() {
    RickAndMortyTheme {
        AppProgressDialog()
    }
}
