package com.arieftaufikrahman.wibuapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arieftaufikrahman.wibuapp.R
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.core.domain.model.Genre
import com.arieftaufikrahman.wibuapp.core.domain.model.Images
import com.arieftaufikrahman.wibuapp.core.domain.model.Jpg
import com.arieftaufikrahman.wibuapp.core.domain.model.Studios
import com.arieftaufikrahman.wibuapp.core.domain.model.Webp
import com.arieftaufikrahman.wibuapp.presentation.Dimension.AnimeCardSize
import com.arieftaufikrahman.wibuapp.presentation.Dimension.ExtraSmallPadding
import com.arieftaufikrahman.wibuapp.presentation.Dimension.ExtraSmallPadding2
import com.arieftaufikrahman.wibuapp.presentation.Dimension.SmallIconSize
import com.arieftaufikrahman.wibuapp.ui.theme.WibuAppTheme

@Composable
fun AnimeCard(
    modifier: Modifier = Modifier,
    data: Data,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(AnimeCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(data.images.webp.image_url).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        // Add Spacer for extra space between the image and the text
        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(AnimeCardSize)
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Handle null or empty genres
                val genreText = data.genres?.joinToString(", ") { it.name } ?: "Unknown Genre"
                Text(
                    text = genreText,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),
                    maxLines = 2,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                // Handle null or empty studios
                val studioText = data.studios?.joinToString(", ") { it.name } ?: "Unknown Studio"
                Text(
                    text = studioText,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),
                    maxLines = 2,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun AnimeCardPreview() {
    WibuAppTheme {
        AnimeCard(
            data = com.arieftaufikrahman.wibuapp.core.domain.model.Data(
                mal_id = 0,
                title = "Frieren: Beyond End's Journey",
                images = com.arieftaufikrahman.wibuapp.core.domain.model.Images(
                    com.arieftaufikrahman.wibuapp.core.domain.model.Jpg(
                        image_url = null,
                        large_image_url = null,
                        small_image_url = null
                    ),
                    com.arieftaufikrahman.wibuapp.core.domain.model.Webp(
                        image_url = "",
                        large_image_url = null,
                        small_image_url = null
                    )
                ),
                score = 7.5,
                synopsis = "",
                episodes = 0,
                airing = false,
                type = "",
                url = "",
                genres = listOf(
                    Genre(
                        mal_id = 0,
                        name = "Adventure",
                        type = "",
                        url = ""
                    ),
                    Genre(
                        mal_id = 1,
                        name = "Fantasy",
                        type = "",
                        url = ""
                    )
                ),
                studios = listOf(
                    Studios(
                        mal_id = 0,
                        name = "Wit Studio",
                        type = "",
                        url = ""
                    )
                )
            ),
            onClick = {}
        )
    }
}
