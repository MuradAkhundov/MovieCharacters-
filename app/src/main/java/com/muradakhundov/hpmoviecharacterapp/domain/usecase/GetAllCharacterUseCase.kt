package com.muradakhundov.hpmoviecharacterapp.domain.usecase

import com.muradakhundov.hpmoviecharacterapp.domain.repository.CharacterRepository
import javax.inject.Inject


class GetAllCharacterUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke() = repository.getAllCharacters()
}