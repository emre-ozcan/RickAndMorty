package com.emreozcan.rickandmorty.detail.data

import com.emreozcan.rickandmorty.detail.data.dto.CharacterDetailResponseDto
import com.emreozcan.rickandmorty.network.NetworkResult

/**
 * Created by @Emre Özcan on 8.06.2024
 */
interface CharacterDetailRepository {
    suspend fun getCharacterDetail(characterId: String): NetworkResult<CharacterDetailResponseDto>
}
