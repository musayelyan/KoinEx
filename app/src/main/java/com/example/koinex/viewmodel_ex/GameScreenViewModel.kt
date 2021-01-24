package com.example.koinex.viewmodel_ex

import androidx.lifecycle.ViewModel

class GameScreenViewModel constructor(private val gameRepository: GameRepository) : ViewModel() {
    fun getGames(): String = gameRepository.getGames()
}