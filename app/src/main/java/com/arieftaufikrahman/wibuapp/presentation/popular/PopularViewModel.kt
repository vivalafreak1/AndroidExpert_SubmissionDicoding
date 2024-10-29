package com.arieftaufikrahman.wibuapp.presentation.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.arieftaufikrahman.wibuapp.core.domain.usecases.anime.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val animeUseCase: AnimeUseCase
): ViewModel() {

    val anime = animeUseCase.getTopAnime(
        data = listOf("mal_id", "title", "images/jpg/image_url", "synopsis")
    ).cachedIn(viewModelScope)
}