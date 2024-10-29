package com.arieftaufikrahman.wibuapp.core.domain.model

data class Pagination(
    val current_page: Int,
    val has_next_page: Boolean,
    val items: com.arieftaufikrahman.wibuapp.core.domain.model.Items,
    val last_visible_page: Int
)