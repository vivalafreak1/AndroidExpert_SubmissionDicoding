package com.arieftaufikrahman.wibuapp.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.arieftaufikrahman.wibuapp.core.data.local.AnimeDao
import com.arieftaufikrahman.wibuapp.core.data.remote.AnimeApi
import com.arieftaufikrahman.wibuapp.core.domain.repository.AnimeRepository
import com.arieftaufikrahman.wibuapp.core.data.remote.AnimePagingSource
import com.arieftaufikrahman.wibuapp.core.data.remote.SearchAnimePagingSource
import com.arieftaufikrahman.wibuapp.core.data.remote.TopAnimePagingSource
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import kotlinx.coroutines.flow.Flow

class AnimeRepositoryImpl(
    private val animeApi: AnimeApi,
    private val animeDao: AnimeDao
) : AnimeRepository {

    override fun getSeasonNow(data: List<String>): Flow<PagingData<Data>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                AnimePagingSource(
                    animeApi = animeApi,
                    data = data.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun getTopAnime(data: List<String>): Flow<PagingData<Data>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                TopAnimePagingSource(
                    animeApi = animeApi,
                    data = data.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun getAnimeSearch(searchQuery: String, data: List<String>): Flow<PagingData<Data>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchAnimePagingSource(
                    searchQuery = searchQuery,
                    animeApi = animeApi,
                    data = data.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertAnime(data: Data) {
        animeDao.upsert(data)
    }

    override suspend fun deleteAnime(data: Data) {
        animeDao.delete(data)
    }

    override fun selectAnimes(): Flow<List<Data>> {
        return animeDao.getSeasonNow()
    }

    override suspend fun selectAnime(mal_id: Int): Data? {
        return animeDao.getAnimeById(mal_id)
    }
}