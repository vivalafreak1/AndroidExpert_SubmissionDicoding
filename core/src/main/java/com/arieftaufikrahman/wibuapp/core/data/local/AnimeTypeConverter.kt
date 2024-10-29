package com.arieftaufikrahman.wibuapp.core.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.arieftaufikrahman.wibuapp.core.domain.model.Images
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.arieftaufikrahman.wibuapp.core.domain.model.*

@ProvidedTypeConverter
class AnimeTypeConverter {

    private val gson = Gson()

    // Convert Images object to a JSON string
    @TypeConverter
    fun imageToString(images: Images): String {
        return gson.toJson(images)
    }

    // Convert JSON string back to Images object
    @TypeConverter
    fun stringToImage(data: String): Images {
        val type = object : TypeToken<Images>() {}.type
        return gson.fromJson(data, type)
    }

    // Convert Jpg object to a JSON string
    @TypeConverter
    fun jpgToString(jpg: Jpg?): String {
        return gson.toJson(jpg)
    }

    // Convert JSON string back to Jpg object
    @TypeConverter
    fun stringToJpg(data: String): Jpg? {
        val type = object : TypeToken<Jpg?>() {}.type
        return gson.fromJson(data, type)
    }

    // Convert Webp object to a JSON string
    @TypeConverter
    fun webpToString(webp: Webp): String {
        return gson.toJson(webp)
    }

    // Convert JSON string back to Webp object
    @TypeConverter
    fun stringToWebp(data: String): Webp {
        val type = object : TypeToken<Webp>() {}.type
        return gson.fromJson(data, type)
    }

    // Convert Genre list to a JSON string
    @TypeConverter
    fun genreListToString(genres: List<Genre>): String {
        return gson.toJson(genres)
    }

    // Convert JSON string back to Genre list
    @TypeConverter
    fun stringToGenreList(data: String): List<Genre> {
        val type = object : TypeToken<List<Genre>>() {}.type
        return gson.fromJson(data, type)
    }

    // Convert Studios list to a JSON string
    @TypeConverter
    fun studiosListToString(studios: List<Studios>): String {
        return gson.toJson(studios)
    }

    // Convert JSON string back to Studios list
    @TypeConverter
    fun stringToStudiosList(data: String): List<Studios> {
        val type = object : TypeToken<List<Studios>>() {}.type
        return gson.fromJson(data, type)
    }
}