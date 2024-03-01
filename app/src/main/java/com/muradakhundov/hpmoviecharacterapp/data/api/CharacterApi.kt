package com.muradakhundov.hpmoviecharacterapp.data.api

import com.muradakhundov.hpmoviecharacterapp.data.dto.CharactersDTO
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters() : List<CharactersDTO>
}