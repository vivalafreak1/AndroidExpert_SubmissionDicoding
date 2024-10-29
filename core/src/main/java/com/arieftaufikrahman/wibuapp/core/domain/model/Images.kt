package com.arieftaufikrahman.wibuapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Images(
    val jpg: com.arieftaufikrahman.wibuapp.core.domain.model.Jpg?,
    val webp: com.arieftaufikrahman.wibuapp.core.domain.model.Webp
): Parcelable