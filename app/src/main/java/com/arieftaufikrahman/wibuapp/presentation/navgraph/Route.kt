package com.arieftaufikrahman.wibuapp.presentation.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object FavoriteScreen : Route(route = "favoriteScreen")
    object DetailScreen : Route(route = "detailScreen")
    object PopularScreen : Route(route = "popularScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object WibuNavigation: Route(route = "wibuNavigation")
    object WibuNavigatorScreen : Route(route = "wibuNavigator")
}