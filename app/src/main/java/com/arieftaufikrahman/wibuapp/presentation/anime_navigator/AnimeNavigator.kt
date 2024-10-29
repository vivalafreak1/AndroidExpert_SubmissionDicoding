package com.arieftaufikrahman.wibuapp.presentation.anime_navigator

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.arieftaufikrahman.wibuapp.R
import com.arieftaufikrahman.wibuapp.core.domain.model.Data
import com.arieftaufikrahman.wibuapp.presentation.anime_navigator.components.AnimeBottomNavigation
import com.arieftaufikrahman.wibuapp.presentation.anime_navigator.components.BottomNavigationItem
import com.arieftaufikrahman.wibuapp.presentation.detail.DetailEvent
import com.arieftaufikrahman.wibuapp.presentation.detail.DetailScreen
import com.arieftaufikrahman.wibuapp.presentation.detail.DetailViewModel
import com.arieftaufikrahman.wibuapp.presentation.favorite.FavoriteScreen
import com.arieftaufikrahman.wibuapp.presentation.favorite.FavoriteViewModel
import com.arieftaufikrahman.wibuapp.presentation.home.HomeScreen
import com.arieftaufikrahman.wibuapp.presentation.home.HomeViewModel
import com.arieftaufikrahman.wibuapp.presentation.navgraph.Route
import com.arieftaufikrahman.wibuapp.presentation.popular.PopularScreen
import com.arieftaufikrahman.wibuapp.presentation.popular.PopularViewModel
import com.arieftaufikrahman.wibuapp.presentation.search.SearchScreen
import com.arieftaufikrahman.wibuapp.presentation.search.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_globe, text = "Popular"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_favorite, text = "Favorite")
        )
    }

    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = remember(key1 = backstackState) {
        when (backstackState?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.PopularScreen.route -> 1
            Route.SearchScreen.route -> 2
            Route.FavoriteScreen.route -> 3
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = backstackState) {
        backstackState?.destination?.route == Route.HomeScreen.route ||
                backstackState?.destination?.route == Route.PopularScreen.route ||
                backstackState?.destination?.route == Route.SearchScreen.route ||
                backstackState?.destination?.route == Route.FavoriteScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                AnimeBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTab(
                                navController = navController,
                                route = Route.HomeScreen.route
                            )

                            1 -> navigateToTab(
                                navController = navController,
                                route = Route.PopularScreen.route
                            )

                            2 -> navigateToTab(
                                navController = navController,
                                route = Route.SearchScreen.route
                            )

                            3 -> navigateToTab(
                                navController = navController,
                                route = Route.FavoriteScreen.route
                            )
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val data = viewModel.anime.collectAsLazyPagingItems()
                HomeScreen(
                    anime = data,
                    navigateToSearch = {
                        navigateToTab(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )
                    },
                    navigateToDetail = { data ->
                        navigateToDetail(
                            navController = navController,
                            data = data
                        )
                    }
                )
            }
            composable(route = Route.PopularScreen.route) {
                val viewModel: PopularViewModel = hiltViewModel()
                val data = viewModel.anime.collectAsLazyPagingItems()
                PopularScreen(
                    anime = data,
                    navigateToDetail = { data ->
                        navigateToDetail(
                            navController = navController,
                            data = data
                        )
                    }
                )
            }
            composable(route = Route.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                SearchScreen(
                    state = state,
                    event = viewModel::onEvent,
                    navigateToDetail = { data ->
                        navigateToDetail(
                            navController = navController,
                            data = data
                        )
                    }
                )
            }

            composable(route = Route.DetailScreen.route) {
                val viewModel: DetailViewModel = hiltViewModel()
                if (viewModel.sideEffect != null) {
                    Toast.makeText(LocalContext.current, viewModel.sideEffect, Toast.LENGTH_SHORT).show()
                    viewModel.onEvent(DetailEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry?.savedStateHandle?.get<com.arieftaufikrahman.wibuapp.core.domain.model.Data?>("data")
                    ?.let { data ->
                        DetailScreen(
                            data = data,
                            event = viewModel::onEvent,
                            navigateUp = { navController.navigateUp() })
                    }
            }
            composable(route = Route.FavoriteScreen.route) {
                val viewModel: FavoriteViewModel = hiltViewModel()
                val state = viewModel.state.value
                FavoriteScreen(state = state, navigateToDetail = { data ->
                    navigateToDetail(navController = navController, data = data)
                })
            }
        }
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetail(navController: NavController, data: Data) {
    navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
    navController.navigate(
        route = Route.DetailScreen.route
    )
}