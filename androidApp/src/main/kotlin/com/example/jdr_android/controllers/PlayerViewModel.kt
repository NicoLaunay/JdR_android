package com.example.jdr_android.controllers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import models.Player
import com.example.jdr_android.services.PlayerService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(private val service: PlayerService) : ViewModel() {

    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players: StateFlow<List<Player>> = _players

    init { load() }

    private fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            _players.value = service.getAll()
        }
    }

    fun add(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            service.add(name)
            load()
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            service.delete(id)
            load()
        }
    }
}