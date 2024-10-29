package com.arieftaufikrahman.wibuapp.core.domain.usecases.anime

data class AnimeUseCase(
    val getSeasonNow: GetSeasonNow,
    val getAnimeSearch: SearchAnime,
    val getTopAnime: GetTopAnime,
    val upsertAnime: UpsertAnime,
    val deleteAnime: DeleteAnime,
    val selectAnimes: SelectAnimes,
    val selectAnime: SelectAnime,
)
