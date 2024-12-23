package com.arieftaufikrahman.wibuapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Studios(
    val mal_id: Int,
    val name: String,
    val type: String,
    val url: String
): Parcelable