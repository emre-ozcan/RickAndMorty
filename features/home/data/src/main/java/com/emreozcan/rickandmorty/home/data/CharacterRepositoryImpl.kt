package com.emreozcan.rickandmorty.home.data

import com.emreozcan.rickandmorty.home.data.dto.CharacterResponseDto
import com.emreozcan.rickandmorty.network.NetworkResult
import com.emreozcan.rickandmorty.network.http.RequestHandler
import javax.inject.Inject

private const val CHARACTER = "character"

class CharacterRepositoryImpl
    @Inject
    constructor(private val requestHandler: RequestHandler) :
    CharacterRepository {
        override suspend fun getCharacters(): NetworkResult<CharacterResponseDto> = requestHandler.get(listOf(CHARACTER))
    }
