package com.arieftaufikrahman.wibuapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.presentation.Dimension.ExtraSmallPadding2
import com.arieftaufikrahman.wibuapp.presentation.Dimension.MediumPadding1

@Composable
fun AnimeList(
    modifier: Modifier = Modifier,
    anime: List<com.arieftaufikrahman.wibuapp.core.domain.model.Data>,
    onClick: (com.arieftaufikrahman.wibuapp.core.domain.model.Data) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(MediumPadding1),
        contentPadding = PaddingValues(all = ExtraSmallPadding2)
    ) {
        items(count = anime.size) {
            val data = anime[it]
            AnimeCard(data = data, onClick = { onClick(data) })
        }
    }
}

@Composable
fun AnimeList(
    modifier: Modifier = Modifier,
    anime: LazyPagingItems<com.arieftaufikrahman.wibuapp.core.domain.model.Data>,
    onClick: (com.arieftaufikrahman.wibuapp.core.domain.model.Data) -> Unit
) {
    val handlePagingResult = handlePagingResult(anime = anime)
    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            items(count = anime.itemCount) {
                anime[it]?.let {
                    AnimeCard(data = it, onClick = { onClick(it) })
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(
    anime: LazyPagingItems<com.arieftaufikrahman.wibuapp.core.domain.model.Data>
): Boolean {
    val loadState = anime.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen()
            false
        }

        else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10) {
            AnimeCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}