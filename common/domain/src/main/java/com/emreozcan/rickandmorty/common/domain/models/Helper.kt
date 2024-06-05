package com.emreozcan.rickandmorty.common.domain.models

import com.emreozcan.rickandmorty.network.NetworkException
import com.emreozcan.rickandmorty.network.NetworkResult

/**
 * Created by @Emre Özcan on 4.06.2024
 */

fun NetworkResult.Error<*>.toResourceError(): Resource.Error {
    return when (exception) {
        is NetworkException.NotFoundException -> Resource.Error(ResourceError.SERVICE_UNAVAILABLE)
        is NetworkException.UnauthorizedException -> Resource.Error(ResourceError.UNAUTHORIZED)
        is NetworkException.UnknownException -> Resource.Error(ResourceError.UNKNOWN)
    }
}
