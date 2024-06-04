package com.emreozcan.rickandmorty.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.emreozcan.rickandmorty.theme.RickAndMortyTheme
import com.emreozcan.rickandmorty.theme.components.RickAndMortyPreview

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@Composable
fun HomeScreen() {
    Home()
}

@Composable
fun Home() {
    Text(text = "Home Screen")
}

@RickAndMortyPreview
@Composable
fun PreviewHomeScreen() {
    RickAndMortyTheme {
        Home()
    }
}