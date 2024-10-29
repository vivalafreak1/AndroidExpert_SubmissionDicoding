package com.arieftaufikrahman.wibuapp.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arieftaufikrahman.wibuapp.core.domain.model.Data

@Database(entities = [Data::class], version = 1)
@TypeConverters(AnimeTypeConverter::class)
abstract class AnimeDatabase: RoomDatabase() {

    abstract val animeDao: AnimeDao
}