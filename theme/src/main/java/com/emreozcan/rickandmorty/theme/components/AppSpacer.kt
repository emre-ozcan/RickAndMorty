package com.emreozcan.rickandmorty.theme.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by @Emre Özcan on 8.06.2024
 */
@Composable
fun AppSpacer(space: Int = 8) {
    Spacer(modifier = Modifier.height(space.dp))
}
