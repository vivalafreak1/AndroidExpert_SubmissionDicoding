package com.arieftaufikrahman.wibuapp.core.domain.usecases.anime

import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class SelectAnimes(
    private val animeRepository: AnimeRepository
) {

    operator fun invoke(): Flow<List<com.arieftaufikrahman.wibuapp.core.domain.model.Data>> {
        return animeRepository.selectAnimes()
    }
}