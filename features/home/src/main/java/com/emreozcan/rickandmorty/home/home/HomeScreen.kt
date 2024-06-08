package com.emreozcan.rickandmorty.home.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.emreozcan.rickandmorty.home.domain.models.getMockCharacterModel
import com.emreozcan.rickandmorty.home.home.components.CharacterItem
import com.emreozcan.rickandmorty.theme.R
import com.emreozcan.rickandmorty.theme.RickAndMortyTheme
import com.emreozcan.rickandmorty.theme.components.AppErrorView
import com.emreozcan.rickandmorty.theme.components.AppProgressDialog
import com.emreozcan.rickandmorty.theme.components.RickAndMortyPreview

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigateToDetail: (String) -> Unit,
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value

    Home(state = state, navigateToDetail = navigateToDetail)
}

@Composable
private fun Home(
    state: HomeUiState,
    navigateToDetail: (String) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        modifier = Modifier.height(40.dp),
                        painter = painterResource(id = R.drawable.rick_and_mort_logo),
                        contentDescription = "Rick and Morty",
                    )
                },
                scrollBehavior = scrollBehavior,
                actions = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                },
            )
        },
    ) { innerPadding ->
        when (state) {
            HomeUiState.Loading -> {
                AppProgressDialog()
            }

            is HomeUiState.RequestError -> {
                AppErrorView(message = state.message)
            }

            is HomeUiState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = innerPadding) {
                    items(state.characterList) {
                        CharacterItem(model = it, navigateToDetail = navigateToDetail)
                    }
                }
            }
        }
    }
}

@RickAndMortyPreview
@Composable
fun PreviewHomeScreenSuccess() {
    RickAndMortyTheme {
        Home(HomeUiState.Success(listOf(getMockCharacterModel()))) {}
    }
}

@RickAndMortyPreview
@Composable
fun PreviewHomeScreenLoading() {
    RickAndMortyTheme {
        Home(HomeUiState.Loading) {}
    }
}

@RickAndMortyPreview
@Composable
fun PreviewHomeScreenError() {
    RickAndMortyTheme {
        Home(HomeUiState.RequestError("An unknown error occurred")) {}
    }
}
