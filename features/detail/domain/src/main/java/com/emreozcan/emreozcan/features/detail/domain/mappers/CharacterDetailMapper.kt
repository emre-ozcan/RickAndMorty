package com.emreozcan.emreozcan.features.detail.domain.mappers

import com.emreozcan.emreozcan.common.utils.Mapper
import com.emreozcan.emreozcan.features.detail.domain.models.CharacterDetailModel
import com.emreozcan.emreozcan.features.detail.domain.models.convertToGender
import com.emreozcan.emreozcan.features.detail.domain.models.convertToStatus
import com.emreozcan.rickandmorty.detail.data.dto.CharacterDetailResponseDto
import javax.inject.Inject

/**
 * Created by @Emre Özcan on 8.06.2024
 */
class CharacterDetailMapper
    @Inject
    constructor() :
    Mapper<CharacterDetailResponseDto?, CharacterDetailModel> {
        override fun map(from: CharacterDetailResponseDto?): CharacterDetailModel =
            CharacterDetailModel(
                name = from?.name ?: "Unknown",
                status = convertToStatus(from?.status),
                gender = convertToGender(from?.gender),
                image = from?.image ?: "",
                origin = from?.origin?.name ?: "Unknown",
                location = from?.location?.name ?: "Unknown",
                species = from?.species ?: "Unknown",
                episodes = from?.episode?.mapNotNull { url -> url?.split("/")?.last() }?.joinToString(", ") ?: "",
            )
    }
