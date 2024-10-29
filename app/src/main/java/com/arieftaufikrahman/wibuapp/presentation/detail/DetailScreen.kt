package com.arieftaufikrahman.wibuapp.presentation.detail

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.presentation.Dimension.AnimeImageHeight
import com.arieftaufikrahman.wibuapp.presentation.Dimension.MediumPadding1
import com.arieftaufikrahman.wibuapp.presentation.detail.components.DetailTopBar

import com.arieftaufikrahman.wibuapp.R
import com.arieftaufikrahman.wibuapp.core.domain.model.Images
import com.arieftaufikrahman.wibuapp.core.domain.model.Jpg
import com.arieftaufikrahman.wibuapp.core.domain.model.Webp
import com.arieftaufikrahman.wibuapp.ui.theme.WibuAppTheme

@Composable
fun DetailScreen(
    data: com.arieftaufikrahman.wibuapp.core.domain.model.Data,
    event: (DetailEvent) -> Unit,
    navigateUp: () -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(data.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, data.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = { event(DetailEvent.UpsertDeleteAnime(data)) },
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest
                        .Builder(context = context).data(data.images.webp.image_url)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AnimeImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = data.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.text_title
                    )
                )

                Text(
                    text = data.synopsis,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.body
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailScreenPreview() {
    WibuAppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            DetailScreen(
                data = com.arieftaufikrahman.wibuapp.core.domain.model.Data(
                    mal_id = 1,
                    title = "Frieren-Sama and the stark brotherhood",
                    images = com.arieftaufikrahman.wibuapp.core.domain.model.Images(
                        jpg = com.arieftaufikrahman.wibuapp.core.domain.model.Jpg(
                            image_url = null,
                            large_image_url = null,
                            small_image_url = null,
                        ),
                        webp = com.arieftaufikrahman.wibuapp.core.domain.model.Webp(
                            image_url = "https://otakumobileague.b-cdn.net/wp-content/uploads/2024/01/Frieren-3206649243-800x445.webp",
                            small_image_url = null,
                            large_image_url = null,
                        ),
                    ),
                    score = 8.9,
                    synopsis = "During their decade-long quest to defeat the Demon King, the members of the hero's party—Himmel himself, the priest Heiter, the dwarf warrior Eisen, and the elven mage Frieren—forge bonds through adventures and battles, creating unforgettable precious memories for most of them.\n" +
                            "\n" +
                            "However, the time that Frieren spends with her comrades is equivalent to merely a fraction of her life, which has lasted over a thousand years. When the party disbands after their victory, Frieren casually returns to her \"usual\" routine of collecting spells across the continent. Due to her different sense of time, she seemingly holds no strong feelings toward the experiences she went through.\n" +
                            "\n" +
                            "As the years pass, Frieren gradually realizes how her days in the hero's party truly impacted her. Witnessing the deaths of two of her former companions, Frieren begins to regret having taken their presence for granted; she vows to better understand humans and create real personal connections. Although the story of that once memorable journey has long ended, a new tale is about to begin.",
                    episodes = 3,
                    airing = true,
                    type = "TV",
                    url = "https://myanimelist.net/anime/52991/Sousou_no_Frieren"
                ),
                event = {},
                navigateUp = {},
            )
        }
    }
}
