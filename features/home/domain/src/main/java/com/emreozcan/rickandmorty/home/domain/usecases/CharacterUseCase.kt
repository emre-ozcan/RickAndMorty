package com.emreozcan.rickandmorty.home.domain.usecases

import com.emreozcan.rickandmorty.common.domain.models.Resource
import com.emreozcan.rickandmorty.common.domain.models.toResourceError
import com.emreozcan.rickandmorty.home.data.CharacterRepository
import com.emreozcan.rickandmorty.home.domain.mappers.CharacterMapper
import com.emreozcan.rickandmorty.home.domain.models.CharacterModel
import com.emreozcan.rickandmorty.network.NetworkResult
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 4.06.2024
 */
class CharacterUseCase
    @Inject
    constructor(
        private val repository: CharacterRepository,
        private val mapper: CharacterMapper,
    ) {
        suspend fun invoke(): Resource<List<CharacterModel>> {
            return when (val response = repository.getCharacters()) {
                is NetworkResult.Error -> response.toResourceError()
                is NetworkResult.Success ->
                    Resource.Success(
                        response.result.results?.map {
                            mapper.map(it)
                        }?.toList() ?: emptyList(),
                    )
            }
        }
    }
