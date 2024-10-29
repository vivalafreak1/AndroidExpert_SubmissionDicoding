package com.arieftaufikrahman.wibuapp.presentation.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.paging.compose.LazyPagingItems
import com.arieftaufikrahman.wibuapp.R
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.presentation.Dimension.MediumPadding1
import com.arieftaufikrahman.wibuapp.presentation.common.AnimeList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularScreen(
    anime: LazyPagingItems<Data>,
    navigateToDetail: (Data) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (anime.itemCount > 10) {
                anime.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {

        Text(
            modifier = Modifier.padding(start = MediumPadding1),
            text = "Popular",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )

        AnimeList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            anime = anime,
            onClick = {
                navigateToDetail(it)
            }
        )
    }
}