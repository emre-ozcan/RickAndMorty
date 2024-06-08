package com.emreozcan.rickandmorty.detail.data

import com.emreozcan.rickandmorty.detail.data.dto.CharacterDetailResponseDto
import com.emreozcan.rickandmorty.network.NetworkResult
import com.emreozcan.rickandmorty.network.http.RequestHandler
import javax.inject.Inject

private const val CHARACTER = "character"

class CharacterDetailRepositoryImpl
    @Inject
    constructor(
        private val requestHandler: RequestHandler,
    ) : CharacterDetailRepository {
        override suspend fun getCharacterDetail(characterId: String): NetworkResult<CharacterDetailResponseDto> =
            requestHandler.get(listOf(CHARACTER, characterId))
    }
