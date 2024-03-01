package com.muradakhundov.hpmoviecharacterapp.presentation.state

import com.muradakhundov.hpmoviecharacterapp.domain.model.Characters

data class CharactersState(
    val characters : List<Characters> ? = emptyList(),
    val errorMsg : String? = "",
    val isLoading : Boolean = false
)
