package com.arieftaufikrahman.wibuapp.core.domain.usecases.anime

import androidx.paging.PagingData
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class GetSeasonNow(
    private val animeRepository: AnimeRepository
) {

    operator fun invoke(data: List<String>): Flow<PagingData<com.arieftaufikrahman.wibuapp.core.domain.model.Data>>{
        return animeRepository.getSeasonNow(data = data)
    }
}