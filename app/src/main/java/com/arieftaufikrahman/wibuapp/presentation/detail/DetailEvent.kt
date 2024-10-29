package com.arieftaufikrahman.wibuapp.presentation.detail

import com.arieftaufikrahman.wibuapp.core.domain.model.Data

sealed class DetailEvent {

    data class UpsertDeleteAnime(val data: com.arieftaufikrahman.wibuapp.core.domain.model.Data): DetailEvent()

    object RemoveSideEffect: DetailEvent()
}