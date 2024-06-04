package com.emreozcan.rickandmorty.theme.components

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@Preview(
    name = "Preview Light",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Preview Night",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class RickAndMortyPreview
