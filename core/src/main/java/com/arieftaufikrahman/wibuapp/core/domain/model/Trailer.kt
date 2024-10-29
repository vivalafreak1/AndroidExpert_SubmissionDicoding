package com.arieftaufikrahman.wibuapp.core.domain.model

data class Trailer(
    val embed_url: String,
    val images: com.arieftaufikrahman.wibuapp.core.domain.model.ImagesX,
    val url: String,
    val youtube_id: String
)