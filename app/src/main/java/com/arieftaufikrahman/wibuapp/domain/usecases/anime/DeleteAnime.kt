package com.arieftaufikrahman.wibuapp.domain.usecases.anime

import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.repository.AnimeRepository

class DeleteAnime(
    private val animeRepository: AnimeRepository
) {

    suspend operator fun invoke(data: com.arieftaufikrahman.wibuapp.core.domain.model.Data) {
        animeRepository.deleteAnime(data)
    }
}