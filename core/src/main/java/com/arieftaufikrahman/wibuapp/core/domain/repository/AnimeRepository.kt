package com.arieftaufikrahman.wibuapp.core.domain.repository

import androidx.paging.PagingData
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun getSeasonNow(data: List<String>): Flow<PagingData<com.arieftaufikrahman.wibuapp.core.domain.model.Data>>

    fun getAnimeSearch(searchQuery: String,data: List<String>): Flow<PagingData<com.arieftaufikrahman.wibuapp.core.domain.model.Data>>

    suspend fun upsertAnime(data: com.arieftaufikrahman.wibuapp.core.domain.model.Data)

    suspend fun deleteAnime(data: com.arieftaufikrahman.wibuapp.core.domain.model.Data)

    fun selectAnimes(): Flow<List<com.arieftaufikrahman.wibuapp.core.domain.model.Data>>

    suspend fun selectAnime(mal_id: Int): com.arieftaufikrahman.wibuapp.core.domain.model.Data?
}