package com.arieftaufikrahman.wibuapp.presentation.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arieftaufikrahman.wibuapp.core.domain.usecases.anime.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val animeUseCase: AnimeUseCase
): ViewModel() {

    private val _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getSeasonNow()
    }

    private fun  getSeasonNow(){
        animeUseCase.selectAnimes().onEach {
            _state.value = _state.value.copy(data = it.asReversed())
        }.launchIn(viewModelScope)
    }

}