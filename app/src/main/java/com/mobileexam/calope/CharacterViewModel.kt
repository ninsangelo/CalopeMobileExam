package com.mobileexam.calope.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobileexam.calope.data.Character
import com.mobileexam.calope.network.CharacterApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val _characterList = MutableStateFlow<List<Character>>(emptyList())
    val characterList: StateFlow<List<Character>> = _characterList

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = CharacterApi.retrofitService.getCharacters()
                _characterList.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCharacterById(id: Int): Character? {
        return _characterList.value.find { it.id == id }
    }
}
