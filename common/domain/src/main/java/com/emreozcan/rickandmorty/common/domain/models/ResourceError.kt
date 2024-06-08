package com.emreozcan.rickandmorty.common.domain.models

enum class ResourceError {
    UNAUTHORIZED,
    SERVICE_UNAVAILABLE,
    UNKNOWN,
}

fun getError(loginError: Resource.Error): String {
    return when (loginError.e) {
        ResourceError.UNAUTHORIZED -> "Unauthorized"
        ResourceError.SERVICE_UNAVAILABLE -> "Service Unavailable"
        ResourceError.UNKNOWN -> "An unknown error occurred"
    }
}
