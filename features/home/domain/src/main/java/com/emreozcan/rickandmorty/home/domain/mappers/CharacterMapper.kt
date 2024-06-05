package com.emreozcan.rickandmorty.home.domain.mappers

import com.emreozcan.emreozcan.common.utils.Mapper
import com.emreozcan.rickandmorty.home.data.dto.Result
import com.emreozcan.rickandmorty.home.domain.models.CharacterModel
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 4.06.2024
 */
class CharacterMapper
    @Inject
    constructor() : Mapper<Result?, CharacterModel> {
        override fun map(from: Result?): CharacterModel =
            CharacterModel(
                name = from?.name ?: "Unknown",
                status = from?.status ?: "Unknown",
                gender = from?.gender ?: "Unknown",
                image = from?.image ?: "",
                origin = from?.origin?.name ?: "Unknown",
                location = from?.location?.name ?: "Unknown",
            )
    }
