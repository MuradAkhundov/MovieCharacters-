package com.muradakhundov.hpmoviecharacterapp.domain.repository

import com.muradakhundov.hpmoviecharacterapp.core.common.Resource
import com.muradakhundov.hpmoviecharacterapp.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacters() : Flow<Resource<List<Characters>>>
}