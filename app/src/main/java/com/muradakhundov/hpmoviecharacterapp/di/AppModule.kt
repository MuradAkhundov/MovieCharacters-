package com.muradakhundov.hpmoviecharacterapp.di

import com.muradakhundov.hpmoviecharacterapp.core.utils.Constants
import com.muradakhundov.hpmoviecharacterapp.data.api.CharacterApi
import com.muradakhundov.hpmoviecharacterapp.data.repo.CharacterRepositoryImpl
import com.muradakhundov.hpmoviecharacterapp.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.
        Builder().
        addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()


    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit) : CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideCharactersRepositoryImpl(api : CharacterApi) : CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}