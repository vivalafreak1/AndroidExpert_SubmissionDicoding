package com.arieftaufikrahman.wibuapp.core.data.remote

import com.arieftaufikrahman.wibuapp.core.data.remote.dto.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {

    @GET("seasons/now")
    suspend fun getSeasonNow(
        @Query("page") page: Int,
        @Query("limit") limit: Int? = 10,         // Optional limit, default to 10 items per page
        @Query("filter") filter: String? = null,  // Optional filter (tv, movie, etc.)
        @Query("sfw") sfw: Boolean? = null,       // Optional SFW flag
        @Query("continuing") continuing: Boolean? = null // Optional flag for continuing series
        // @Query("data") data: String,
        // @Query("filter") filter: String,
        // @Query("apiKey") apiKey: String
    ): AnimeResponse

    @GET("anime")
    suspend fun getAnimeSearch(
        @Query("q") searchQuery: String,                // Search query (required)
        @Query("page") page: Int,            // Page number (default to 1)
        @Query("limit") limit: Int? = 10,         // Limit results per page (default to 10)
        @Query("type") type: String? = null,      // Type of anime (tv, movie, etc.)
        @Query("status") status: String? = null,  // Status of anime (airing, complete, etc.)
        @Query("rating") rating: String? = null,  // Rating (g, pg, pg13, etc.)
        @Query("genres") genres: String? = null,  // Filter by genre IDs
        @Query("genres_exclude") genresExclude: String? = null,  // Exclude genre IDs
        @Query("order_by") orderBy: String? = null,  // Order by property (title, score, etc.)
        @Query("sort") sort: String? = null,      // Sort direction (asc, desc)
        @Query("sfw") sfw: Boolean? = null,       // Safe for work flag
        @Query("unapproved") unapproved: Boolean? = null, // Include unapproved entries
        @Query("min_score") minScore: Double? = null,  // Minimum score filter
        @Query("max_score") maxScore: Double? = null,  // Maximum score filter
        @Query("start_date") startDate: String? = null,  // Filter by start date (YYYY-MM-DD)
        @Query("end_date") endDate: String? = null,      // Filter by end date (YYYY-MM-DD)
        @Query("letter") letter: String? = null,         // Filter by first letter
        @Query("producers") producers: String? = null    // Filter by producer IDs
    ): AnimeResponse
}