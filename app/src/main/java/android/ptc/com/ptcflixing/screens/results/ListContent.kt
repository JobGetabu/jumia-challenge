@file:OptIn(ExperimentalFoundationApi::class)

package android.ptc.com.ptcflixing.screens.results

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import android.ptc.com.ptcflixing.model.configurations.Configurations
import android.ptc.com.ptcflixing.model.search.Result
import android.ptc.com.ptcflixing.navigation.Screen
import com.example.paging3demo.screens.state.ErrorItem
import com.example.paging3demo.screens.state.LoadingItem
import com.example.paging3demo.screens.state.LoadingView
import android.ptc.com.ptcflixing.ui.theme.Orange
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalCoilApi
@Composable
fun ListContent(items: LazyPagingItems<Result>, navController: NavHostController, config: Configurations) {

    Box(modifier = Modifier.fillMaxSize()) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(items.itemCount) { item ->
                ProductItem(product = items[item]!!, navController = navController, config)
            }

        })
        LazyColumn(modifier = Modifier.align(Alignment.Center),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, content = {
            items.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { LoadingView(modifier = Modifier.fillMaxSize()) }
                    }
                    loadState.append is LoadState.Loading -> {
                        item { LoadingItem() }
                    }
                    loadState.refresh is LoadState.Error -> {
                        item {
                            ErrorItem(
                                message = "No Result Found For the Search",
                                modifier = Modifier.fillMaxSize(),
                                onClickRetry = { retry() }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        val e = items.loadState.append as LoadState.Error
                        Log.d("Error",e.toString() )
                    }

                }
            }
        })

    }

}

@ExperimentalCoilApi
@Composable
fun ProductItem(product: Result, navController: NavHostController, config: Configurations) {
    Box(
        modifier = Modifier
            .clickable {
                navController.navigate(Screen.Details.skuQuery(sku = product.sku))
            }
            .height(300.dp)
            .fillMaxWidth()
            .border(0.5.dp, Color.LightGray),
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp, top = 10.dp, end = 10.dp, start = 10.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(product.image)
                .crossfade(500)
                .build(),
            contentDescription = "Product Image",
            contentScale = ContentScale.Fit,

            )


        Column(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = product.brand,
                color = Color.Gray,
                fontSize = MaterialTheme.typography.subtitle2.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text =  product.name,
                style = TextStyle(fontWeight = FontWeight.Black),

                color = Color.Black,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row() {
                Text(
                    modifier = Modifier.padding(end = 40.dp),
                    text = buildAnnotatedString {
                        append(config.metadata.currency.currencySymbol)
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                            append(product.specialPrice.toString())
                        }

                    },
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Box(modifier = Modifier
                    .border(2.dp, Orange)
                    .align(Alignment.CenterVertically) ){

                    Text(
                        text = buildAnnotatedString {
                            append(" ")
                            append(product.maxSavingPercentage.toString())
                            append("% ")
                        },
                        style = TextStyle(fontWeight = FontWeight.Black),
                        color = Orange,
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        maxLines = 1)
                }

            }
            Text(
               text = buildAnnotatedString {
                    append(config.metadata.currency.currencySymbol)
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(product.price.toString())
                    }

                },
                style = TextStyle(textDecoration = TextDecoration.LineThrough),
                color = Color.Gray,
                fontSize = MaterialTheme.typography.caption.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            var rating = product.ratingAverage?.toFloat()
            if (rating != null) {
                RatingBar(
                    modifier = Modifier.padding(bottom = 5.dp, top = 5.dp),
                    value = rating,
                    config = RatingBarConfig()
                        .size(12.dp)
                        .style(RatingBarStyle.HighLighted),
                    onValueChange = {
                        rating = it
                    },
                    onRatingChanged = {
                        Log.d("TAG", "onRatingChanged: $it")
                    }
                )
            }

        }
    }
}

