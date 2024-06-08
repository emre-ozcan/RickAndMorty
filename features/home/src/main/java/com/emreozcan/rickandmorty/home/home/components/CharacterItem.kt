package com.emreozcan.rickandmorty.home.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.emreozcan.rickandmorty.home.domain.models.CharacterModel
import com.emreozcan.rickandmorty.home.domain.models.getMockCharacterModel
import com.emreozcan.rickandmorty.theme.RickAndMortyTheme
import com.emreozcan.rickandmorty.theme.components.RickAndMortyPreview
import com.emreozcan.rickandmorty.theme.components.StatusCircle

/**
 * Created by @Emre Özcan on 5.06.2024
 */
@Composable
fun CharacterItem(
    model: CharacterModel,
    navigateToDetail: (String) -> Unit,
) {
    model.status
    Card(
        modifier =
            Modifier
                .padding(vertical = 6.dp, horizontal = 12.dp)
                .clickable {
                    navigateToDetail.invoke(model.id.toString())
                },
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(150.dp),
        ) {
            SubcomposeAsyncImage(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                model = model.image,
                contentScale = ContentScale.Crop,
                contentDescription = "Image of character",
                error = { rememberVectorPainter(image = Icons.Default.Warning) },
                loading = {
                    Box {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                },
            )
            Column(
                modifier =
                    Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .padding(start = 10.dp, top = 8.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(
                        text = model.name,
                        style = MaterialTheme.typography.titleLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        StatusCircle(status = model.status)
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = "${model.status.status} - ${model.gender.gender}",
                        )
                    }
                }
                Column {
                    Text(
                        text = "Last known location",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.W300,
                    )
                    Text(
                        text = model.location,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Column {
                    Text(
                        text = "Origin",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.W300,
                    )
                    Text(
                        text = model.origin,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@RickAndMortyPreview
@Composable
fun PreviewCharacterItem() {
    RickAndMortyTheme {
        Surface {
            CharacterItem(model = getMockCharacterModel()) {}
        }
    }
}
