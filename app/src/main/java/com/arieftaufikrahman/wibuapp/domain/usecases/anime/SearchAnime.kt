package com.arieftaufikrahman.wibuapp.domain.usecases.anime

import androidx.paging.PagingData
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class SearchAnime(
    private val animeRepository: AnimeRepository
) {

    operator fun invoke(searchQuery: String, data: List<String>): Flow<PagingData<com.arieftaufikrahman.wibuapp.core.domain.model.Data>> {
        return animeRepository.getAnimeSearch(searchQuery = searchQuery, data = data)
    }
}