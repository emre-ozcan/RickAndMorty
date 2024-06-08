package com.emreozcan.rickandmorty.detail.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.emreozcan.emreozcan.features.detail.domain.models.CharacterDetailModel
import com.emreozcan.rickandmorty.theme.components.AppSpacer
import com.emreozcan.rickandmorty.theme.components.StatusCircle

/**
 * Created by @Emre Özcan on 8.06.2024
 */
@Composable
fun CharacterDetailItem(
    character: CharacterDetailModel,
    innerPadding: PaddingValues,
) {
    Column(
        modifier =
            Modifier
                .padding(16.dp)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
    ) {
        SubcomposeAsyncImage(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
                    .clip(RoundedCornerShape(16.dp)),
            model = character.image,
            contentScale = ContentScale.Crop,
            contentDescription = "Image of character",
            error = { rememberVectorPainter(image = Icons.Default.Warning) },
            loading = {
                Box {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            },
        )

        AppSpacer()

        Text(
            text = character.name,
            style = MaterialTheme.typography.headlineLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        AppSpacer()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            AssistChip(
                onClick = {},
                label = { Text(text = character.status.status) },
                leadingIcon = { StatusCircle(status = character.status.ordinal) },
            )

            AssistChip(
                onClick = { },
                label = { Text(text = character.species) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "Species",
                    )
                },
            )

            AssistChip(
                onClick = { },
                label = { Text(text = character.gender.gender) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Species",
                    )
                },
            )
        }

        AppSpacer(space = 16)

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                )
            },
            headlineContent = {
                Text(
                    text = character.location,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            overlineContent = {
                Text(
                    text = "Last known location",
                )
            },
        )

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Origin",
                )
            },
            headlineContent = {
                Text(
                    text = character.origin,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            overlineContent = {
                Text(
                    text = "Origin",
                )
            },
        )

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Location",
                )
            },
            headlineContent = {
                Text(
                    text = "Episodes",
                )
            },
            supportingContent = {
                Text(text = character.episodes)
            },
        )
    }
}
