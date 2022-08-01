

package android.ptc.com.ptcflixing.screens.splash

import android.ptc.com.ptcflixing.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import android.ptc.com.ptcflixing.data.remote.Status
import android.ptc.com.ptcflixing.model.configurations.Configurations
import android.ptc.com.ptcflixing.screens.common.ConfigurationsViewModel
import com.example.paging3demo.screens.state.ErrorItem
import com.example.paging3demo.screens.state.LoadingView

@OptIn(ExperimentalPagingApi::class)
@Composable
fun SplashScreen(launchSearchScreen: () -> Unit = {},
                 configurationsViewModel: ConfigurationsViewModel = hiltViewModel()
) {

    val res by configurationsViewModel.configurationsLiveData.observeAsState()
    val saveConfig by configurationsViewModel.insertLiveData.observeAsState()

    LaunchedEffect(true) {
        configurationsViewModel.addConfigurations()
    }

    if(saveConfig!=null && saveConfig!! > 0) {
        LaunchedEffect(true) {
                launchSearchScreen()
            }

    }
        when(res?.status) {

            Status.SUCCESS -> {

                val config = Configurations(metadata =res?.data!!.metadata, session = res?.data!!.session, success = res?.data!!.success )

                LaunchedEffect(true) {
                    configurationsViewModel.cacheConfigurations(config)
                }
            }
            Status.LOADING -> {
                LoadingView(modifier = Modifier.fillMaxSize().background(Color.White)
                    .padding(top = 250.dp))

            }
            Status.ERROR -> {
                ErrorItem(
                    message = "Oops!! An error occurred",
                    modifier = Modifier.fillMaxSize(),
                    onClickRetry = { }
                )
                     }
            else -> {}

    }

    Box(modifier = Modifier.fillMaxSize()) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.jumia_logo),
            contentDescription = null,
            tint = Color.Black
        )
    }

}

@OptIn(ExperimentalPagingApi::class)
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
