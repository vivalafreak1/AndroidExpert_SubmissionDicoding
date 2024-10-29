package com.arieftaufikrahman.wibuapp.core.data.remote.dto

import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.model.Pagination

data class AnimeResponse(
    val data: List<Data>,
    val pagination: Pagination
)