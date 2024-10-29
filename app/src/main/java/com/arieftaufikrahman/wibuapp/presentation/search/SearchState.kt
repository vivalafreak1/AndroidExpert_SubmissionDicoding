package com.arieftaufikrahman.wibuapp.presentation.search

import androidx.paging.PagingData
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val data: Flow<PagingData<com.arieftaufikrahman.wibuapp.core.domain.model.Data>>? = null
)