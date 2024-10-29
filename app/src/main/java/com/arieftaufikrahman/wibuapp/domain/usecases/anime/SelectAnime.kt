package com.arieftaufikrahman.wibuapp.domain.usecases.anime

import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.repository.AnimeRepository

class SelectAnime(
    private val animeRepository: AnimeRepository
) {

    suspend operator fun invoke(mal_id: Int): com.arieftaufikrahman.wibuapp.core.domain.model.Data? {
        return animeRepository.selectAnime(mal_id)
    }
}