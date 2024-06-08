package com.emreozcan.rickandmorty.theme.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by @Emre Özcan on 5.06.2024
 */
@Composable
fun StatusCircle(status: Int) {
    Canvas(
        modifier = Modifier.size(10.dp),
        onDraw = {
            drawCircle(color = getCircleColor(status))
        },
    )
}

@RickAndMortyPreview
@Composable
fun PreviewStatusCircleAlive() {
    Column {
        StatusCircle(status = 0)
        StatusCircle(status = 1)
        StatusCircle(status = 2)
    }
}

private fun getCircleColor(status: Int): Color {
    return when (status) {
        0 -> Color.Green
        1 -> Color.Red
        else -> Color.Gray
    }
}
