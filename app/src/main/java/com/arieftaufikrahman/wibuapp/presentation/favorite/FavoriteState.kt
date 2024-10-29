package com.arieftaufikrahman.wibuapp.presentation.favorite

import com.arieftaufikrahman.wibuapp.core.domain.model.Data

data class FavoriteState(
    val data: List<Data> = emptyList()
)
