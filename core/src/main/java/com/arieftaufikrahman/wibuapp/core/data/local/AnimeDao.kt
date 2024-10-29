package com.arieftaufikrahman.wibuapp.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(data: Data)

    @Delete
    suspend fun delete(data: Data)

    @Query("SELECT * FROM Data")
    fun getSeasonNow(): Flow<List<Data>>

    @Query("SELECT * FROM Data WHERE mal_id=:mal_id")
    suspend fun getAnimeById(mal_id: Int): Data?

}