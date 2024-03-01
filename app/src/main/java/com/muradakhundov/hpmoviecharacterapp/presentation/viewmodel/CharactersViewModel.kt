package com.muradakhundov.hpmoviecharacterapp.presentation.viewmodel

import android.text.style.CharacterStyle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muradakhundov.hpmoviecharacterapp.core.common.Resource
import com.muradakhundov.hpmoviecharacterapp.domain.usecase.GetAllCharacterUseCase
import com.muradakhundov.hpmoviecharacterapp.presentation.state.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase : GetAllCharacterUseCase) : ViewModel() {

    private val _characterState = MutableStateFlow(CharactersState())
    val characterState : StateFlow<CharactersState>
        get() = _characterState

    init {
        getAllCharacters()
    }

    private fun getAllCharacters(){
        useCase().onEach {
            when(it){
                is Resource.Error -> {
                    _characterState.value = CharactersState().copy(errorMsg = it.msg)
                }
                is Resource.Loading -> {
                    _characterState.value = CharactersState().copy(isLoading = true)
                }
                is Resource.Success -> {
                    _characterState.value = CharactersState().copy(characters = it.data)

                }
            }
        }.launchIn(viewModelScope)
    }
}