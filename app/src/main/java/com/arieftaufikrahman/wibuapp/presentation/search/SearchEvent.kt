package com.arieftaufikrahman.wibuapp.presentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    object SearchAnime : SearchEvent()
}