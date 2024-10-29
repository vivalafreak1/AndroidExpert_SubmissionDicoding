package com.arieftaufikrahman.wibuapp.core.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/*data class Data(
    val aired: com.loc.wibuapp.domain.model.Aired,
    val airing: Boolean,
    val approved: Boolean,
    val background: String,
    val broadcast: com.loc.wibuapp.domain.model.Broadcast,
    val demographics: List<com.loc.wibuapp.domain.model.Demographic>,
    val duration: String,
    val episodes: Int,
    val explicit_genres: List<Any>,
    val favorites: Int,
    val genres: List<com.loc.wibuapp.domain.model.Genre>,
    val images: com.loc.wibuapp.domain.model.Images,
    val licensors: List<com.loc.wibuapp.domain.model.Licensor>,
    val mal_id: Int,
    val members: Int,
    val popularity: Int,
    val producers: List<com.loc.wibuapp.domain.model.Producer>,
    val rank: Int,
    val rating: String,
    val score: Double,
    val scored_by: Int,
    val season: String,
    val source: String,
    val status: String,
    val studios: List<com.loc.wibuapp.domain.model.Studio>,
    val synopsis: String,
    val themes: List<com.loc.wibuapp.domain.model.Theme>,
    val title: String,
    val title_english: String,
    val title_japanese: String,
    val title_synonyms: List<String>,
    val titles: List<com.loc.wibuapp.domain.model.Title>,
    val trailer: com.loc.wibuapp.domain.model.Trailer,
    val type: String,
    val url: String,
    val year: Int
)*/

@Parcelize
@Entity
data class Data(
    @PrimaryKey val mal_id: Int,
    val title: String,
    val images: com.arieftaufikrahman.wibuapp.core.domain.model.Images,
    val score: Double,
    val synopsis: String,
    val episodes: Int,
    val airing: Boolean,
    val type: String,
    val url: String,
    val genres: List<com.arieftaufikrahman.wibuapp.core.domain.model.Genre> = emptyList(),
    val studios: List<com.arieftaufikrahman.wibuapp.core.domain.model.Studios> = emptyList()
): Parcelable