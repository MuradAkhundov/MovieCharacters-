package com.muradakhundov.hpmoviecharacterapp.presentation.navigation

sealed class Screen(val route : String) {
    object CharacterScreen : Screen("character_screen")
}