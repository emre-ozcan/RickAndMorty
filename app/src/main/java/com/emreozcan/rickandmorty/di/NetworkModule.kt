package com.emreozcan.rickandmorty.di

import com.emreozcan.rickandmorty.BuildConfig
import com.emreozcan.rickandmorty.network.http.AppHttpClientBuilder
import com.emreozcan.rickandmorty.network.http.RequestHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

/**
 * Created by @Emre Özcan on 4.06.2024
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideHttpClient(): HttpClient =
        AppHttpClientBuilder()
            .host(BuildConfig.NETWORK_HOST)
            .build()

    @Provides
    fun provideRequestHandler(client: HttpClient) = RequestHandler(client)
}