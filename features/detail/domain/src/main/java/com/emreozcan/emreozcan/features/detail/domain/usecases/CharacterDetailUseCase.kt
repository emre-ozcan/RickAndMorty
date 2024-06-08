package com.emreozcan.emreozcan.features.detail.domain.usecases

import com.emreozcan.emreozcan.features.detail.domain.mappers.CharacterDetailMapper
import com.emreozcan.emreozcan.features.detail.domain.models.CharacterDetailModel
import com.emreozcan.rickandmorty.common.domain.models.Resource
import com.emreozcan.rickandmorty.common.domain.models.toResourceError
import com.emreozcan.rickandmorty.detail.data.CharacterDetailRepository
import com.emreozcan.rickandmorty.network.NetworkResult
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 8.06.2024
 */
class CharacterDetailUseCase
    @Inject
    constructor(
        private val repository: CharacterDetailRepository,
        private val mapper: CharacterDetailMapper,
    ) {
        suspend fun invoke(characterId: String): Resource<CharacterDetailModel> {
            return when (val response = repository.getCharacterDetail(characterId = characterId)) {
                is NetworkResult.Error -> response.toResourceError()
                is NetworkResult.Success ->
                    Resource.Success(
                        mapper.map(response.result),
                    )
            }
        }
    }
