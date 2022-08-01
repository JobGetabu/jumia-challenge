package android.ptc.com.ptcflixing.screens.results

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import android.ptc.com.ptcflixing.screens.common.ConfigurationsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalPagingApi
@ExperimentalCoilApi
@Composable
fun ResultsScreen(
    navController: NavHostController,
    resultsViewModel: ResultsViewModel = hiltViewModel(),
    configurationsViewModel: ConfigurationsViewModel = hiltViewModel(),
    searchQuery: String
) {

    val res by configurationsViewModel.readConfigurationsLiveData.observeAsState()

    LaunchedEffect(true) {
        configurationsViewModel.readConfigurations()
    }

    val products = resultsViewModel.searchedProducts.collectAsLazyPagingItems()

    resultsViewModel.searchProducts(query = searchQuery)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ResultsTopBar(onClicked = {navController.popBackStack()}, "$searchQuery results") },
        content = {
            res.let {
                if (it != null) {
                    ListContent(items = products, navController = navController, config = it)
                }
            }

        }
    )
}