package com.emreozcan.rickandmorty.network

/**
 * Created by @Emre Özcan on 4.06.2024
 */
sealed class NetworkResult<out T> {
    data class Success<T>(val result: T) : NetworkResult<T>()
    data class Error<Nothing>(val body: String?, val exception: NetworkException) :
        NetworkResult<Nothing>()
}