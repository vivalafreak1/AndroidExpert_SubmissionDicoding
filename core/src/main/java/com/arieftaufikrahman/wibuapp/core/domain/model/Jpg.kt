package com.arieftaufikrahman.wibuapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jpg(
    val image_url: String?,
    val large_image_url: String?,
    val small_image_url: String?
): Parcelable