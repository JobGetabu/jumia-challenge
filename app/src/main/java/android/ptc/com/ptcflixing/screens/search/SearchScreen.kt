package android.ptc.com.ptcflixing.screens.search

import android.annotation.SuppressLint
import android.ptc.com.ptcflixing.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import android.ptc.com.ptcflixing.navigation.Screen
import android.ptc.com.ptcflixing.screens.results.ResultsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalCoilApi
@ExperimentalPagingApi

@Composable
fun SearchScreen(
    navController: NavHostController,
    resultsViewModel: ResultsViewModel = hiltViewModel()
) {
    val searchQuery by resultsViewModel.searchQuery

    Scaffold(
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .width(100.dp)
                        .height(300.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.jumia_logo),
                    contentDescription = null,
                    tint = Color.Black
                )
                    SearchWidget(
                        text = searchQuery,
                        onTextChange = {
                            resultsViewModel.updateSearchQuery(query = it)

                        },
                        onSearchClicked = {
                            navController.navigate(Screen.Results.searchQuery(searchQuery))
                        },
                        onCloseClicked = {}
                    )
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(alignment = Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    text = "Jumia Search",
                    style = TextStyle(fontWeight = FontWeight.Black),
                    color = Color.LightGray,
                    fontSize = MaterialTheme.typography.body1.fontSize)
                }

        }
    )

}

@Composable
@Preview(showBackground = true)
fun SearchWidgetPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .width(100.dp)
                .height(300.dp)
                .align(alignment = Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.jumia_logo),
            contentDescription = null,
            tint = Color.Black
        )
        SearchWidget(
            text = "Search",
            onTextChange = {},
            onSearchClicked = {},
            onCloseClicked = {}
        )
    }
}
@Composable
fun SearchWidget(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(56.dp)
            .semantics {
                contentDescription = "SearchWidget"
            },
        elevation = AppBarDefaults.TopAppBarElevation,
        shape = RoundedCornerShape(50.dp)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = "TextField"
                },
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    text = "Search here...",
                    color = Color.Gray
                )
            },
            textStyle = TextStyle(
                color = Color.Black
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier
                        .semantics {
                            contentDescription = "CloseButton"
                        },
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = Color.Gray
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                cursorColor = Color.Gray
            )
        )
    }
}