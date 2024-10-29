package com.arieftaufikrahman.wibuapp.core.domain.usecases.anime

import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.repository.AnimeRepository

class UpsertAnime(
    private val animeRepository: AnimeRepository
) {

    suspend operator fun invoke(data: com.arieftaufikrahman.wibuapp.core.domain.model.Data) {
        animeRepository.upsertAnime(data)
    }
}