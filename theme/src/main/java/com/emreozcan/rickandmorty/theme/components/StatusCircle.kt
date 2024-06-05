package com.emreozcan.rickandmorty.theme.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.emreozcan.rickandmorty.home.domain.models.Status

/**
 * Created by @Emre Özcan on 5.06.2024
 */
@Composable
fun StatusCircle(status: Status) {
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
        StatusCircle(status = Status.ALIVE)
        StatusCircle(status = Status.DEAD)
        StatusCircle(status = Status.UNKNOWN)
    }
}

private fun getCircleColor(status: Status): Color {
    return when (status) {
        Status.ALIVE -> Color.Green
        Status.DEAD -> Color.Red
        Status.UNKNOWN -> Color.Gray
    }
}
