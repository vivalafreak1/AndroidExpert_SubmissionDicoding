package com.arieftaufikrahman.wibuapp.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.arieftaufikrahman.wibuapp.core.domain.usecases.anime.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val animeUseCase: AnimeUseCase
): ViewModel(){

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchAnime -> {
                searchAnime()
            }
        }
    }

    private fun searchAnime() {
        val data = animeUseCase.getAnimeSearch(
            searchQuery = state.value.searchQuery,
            data = listOf("mal_id", "title", "images/jpg/image_url", "synopsis")
        ).cachedIn(viewModelScope)
        _state.value = state.value.copy(data = data)
    }

}