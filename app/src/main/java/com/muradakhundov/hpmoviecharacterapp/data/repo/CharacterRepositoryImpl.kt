package com.muradakhundov.hpmoviecharacterapp.data.repo

import com.muradakhundov.hpmoviecharacterapp.core.common.Resource
import com.muradakhundov.hpmoviecharacterapp.data.api.CharacterApi
import com.muradakhundov.hpmoviecharacterapp.data.mapper.toDomainCharacter
import com.muradakhundov.hpmoviecharacterapp.domain.model.Characters
import com.muradakhundov.hpmoviecharacterapp.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) : CharacterRepository {

    override fun getAllCharacters(): Flow<Resource<List<Characters>>> = flow{
        emit(Resource.Loading())

        val result = characterApi.getAllCharacters().map {
            it.toDomainCharacter()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

}