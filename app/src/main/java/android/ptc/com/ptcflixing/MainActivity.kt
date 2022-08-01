package android.ptc.com.ptcflixing

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import android.ptc.com.ptcflixing.screens.MainScreen
import android.ptc.com.ptcflixing.ui.theme.PtcDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalCoilApi::class, ExperimentalFoundationApi::class, ExperimentalAnimationApi::class,
    ExperimentalMaterialApi::class)
@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var backPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PtcDemoTheme(darkTheme = false) {
                MainScreen(finish = finish)
            }
        }
    }
    private val finish: () -> Unit = {
        if (backPressed + 3000 > System.currentTimeMillis()) {
            finishAndRemoveTask()
        } else {
            Toast.makeText(
                this,
                "Press again to exit",
                Toast.LENGTH_SHORT
            ).show()
        }
        backPressed = System.currentTimeMillis()
    }
}