package com.arieftaufikrahman.wibuapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.presentation.Dimension.MediumPadding1
import com.arieftaufikrahman.wibuapp.presentation.common.AnimeList
import com.arieftaufikrahman.wibuapp.presentation.common.SearchBar

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetail: (com.arieftaufikrahman.wibuapp.core.domain.model.Data) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchAnime) }
        )
        
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.data?.let {
            val data = it.collectAsLazyPagingItems()
            AnimeList(anime = data, onClick = {navigateToDetail(it)})
        }
    }
}