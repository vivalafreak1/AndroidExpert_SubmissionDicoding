package com.arieftaufikrahman.wibuapp.domain.usecases.anime

data class AnimeUseCase(
    val getSeasonNow: GetSeasonNow,
    val getAnimeSearch: SearchAnime,
    val upsertAnime: UpsertAnime,
    val deleteAnime: DeleteAnime,
    val selectAnimes: SelectAnimes,
    val selectAnime: SelectAnime
)
