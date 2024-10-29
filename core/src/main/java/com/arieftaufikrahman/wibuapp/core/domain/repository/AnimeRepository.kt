package com.arieftaufikrahman.wibuapp.core.domain.repository

import androidx.paging.PagingData
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun getSeasonNow(data: List<String>): Flow<PagingData<Data>>

    fun getTopAnime(data: List<String>): Flow<PagingData<Data>>

    fun getAnimeSearch(searchQuery: String,data: List<String>): Flow<PagingData<Data>>

    suspend fun upsertAnime(data: Data)

    suspend fun deleteAnime(data: Data)

    fun selectAnimes(): Flow<List<Data>>

    suspend fun selectAnime(mal_id: Int): Data?
}