package com.arieftaufikrahman.wibuapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.arieftaufikrahman.wibuapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Welcome to WibuApp",
        description = "An experiment Android Application that display the list of Anime from MyAnimeList",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Powered by Jikan API",
        description = "Special thanks to Jikan API for providing data fetched from MyAnimeList",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Let's Explore!",
        description = "Let's explore the world of Anime together!",
        image = R.drawable.onboarding3
    )
)
