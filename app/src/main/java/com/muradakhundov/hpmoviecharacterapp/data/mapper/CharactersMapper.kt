package com.muradakhundov.hpmoviecharacterapp.data.mapper

import com.muradakhundov.hpmoviecharacterapp.data.dto.CharactersDTO
import com.muradakhundov.hpmoviecharacterapp.domain.model.Characters

fun CharactersDTO.toDomainCharacter() : Characters{
    return Characters(actor, id, image, name)
}