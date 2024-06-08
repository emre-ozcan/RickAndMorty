package com.emreozcan.rickandmorty.di

import com.emreozcan.rickandmorty.detail.data.CharacterDetailRepository
import com.emreozcan.rickandmorty.detail.data.CharacterDetailRepositoryImpl
import com.emreozcan.rickandmorty.home.data.CharacterRepository
import com.emreozcan.rickandmorty.home.data.CharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun provideCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository = impl

    @Provides
    fun provideCharacterDetailRepository(impl: CharacterDetailRepositoryImpl): CharacterDetailRepository = impl
}
