package com.emreozcan.rickandmorty.home.data

import com.emreozcan.rickandmorty.home.data.dto.CharacterResponseDto
import com.emreozcan.rickandmorty.network.NetworkResult

/**
 * Created by @Emre Özcan on 4.06.2024
 */
interface CharacterRepository {
    suspend fun getCharacters(): NetworkResult<CharacterResponseDto>
}
