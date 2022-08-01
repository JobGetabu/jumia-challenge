package android.ptc.com.ptcflixing.screens.results

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.ptc.com.ptcflixing.ui.theme.topAppBarBackgroundColor
import android.ptc.com.ptcflixing.ui.theme.topAppBarContentColor

@Composable
fun ResultsTopBar(onClicked: () -> Unit, title: String ) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick =  onClicked) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back"
                )
            }
        },
        title = {
            Text(
                text = title,
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {

                Icon(modifier = Modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Shopping Cart"
                )

                Icon(modifier = Modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menu"
                )

        }
    )
}
