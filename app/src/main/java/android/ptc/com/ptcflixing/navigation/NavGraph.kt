package android.ptc.com.ptcflixing.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import android.ptc.com.ptcflixing.screens.common.ConfigurationsViewModel
import android.ptc.com.ptcflixing.screens.details.DetailsScreen
import android.ptc.com.ptcflixing.screens.details.DetailsViewModel
import android.ptc.com.ptcflixing.screens.results.ResultsScreen
import android.ptc.com.ptcflixing.screens.results.ResultsViewModel
import android.ptc.com.ptcflixing.screens.search.SearchScreen
import android.ptc.com.ptcflixing.screens.splash.SplashScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(router: Router,
                  navController: NavHostController,
                  resultsViewModel: ResultsViewModel = hiltViewModel(),
                  detailsViewModel: DetailsViewModel = hiltViewModel(),
                  configurationsViewModel: ConfigurationsViewModel = hiltViewModel(),
) {

    val startDestination = remember { mutableStateOf(Screen.Splash.route) }
    LaunchedEffect(startDestination) {
        if (startDestination.value == Screen.Search.route) {
            router.goSearch()
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination.value
    ) {
        composable(route = Screen.Splash.route){
            SplashScreen(
                launchSearchScreen = {
                    startDestination.value=  Screen.Search.route
                }
            )

        }
        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.Results.route,
            arguments = listOf(navArgument(SEARCH_ARGUMENT_KEY){
                type = NavType.StringType
            })
        ){

            ResultsScreen(navController = navController, resultsViewModel,
                configurationsViewModel = configurationsViewModel,
                searchQuery = it.arguments?.getString(SEARCH_ARGUMENT_KEY).toString() )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(SKU_ARGUMENT_KEY){
                type = NavType.StringType
            })
        ){

            DetailsScreen(navController = navController,
                 detailsViewModel =  detailsViewModel,
                sku = it.arguments?.getString(SKU_ARGUMENT_KEY).toString(),
                configurationsViewModel = configurationsViewModel)
        }
    }
}