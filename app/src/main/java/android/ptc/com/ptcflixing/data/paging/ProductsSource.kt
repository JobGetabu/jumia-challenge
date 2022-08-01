
package android.ptc.com.ptcflixing.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import android.ptc.com.ptcflixing.data.repository.Repository
import android.ptc.com.ptcflixing.model.search.Result

@OptIn(ExperimentalPagingApi::class)
class ProductsSource
(
    private val repository: Repository,
    private val query:String
) : PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val nextPage = params.key ?: 1
            val response = repository.searchProducts(query, nextPage )
            val endOfPaginationReached = response.metadata.results.isEmpty()

            LoadResult.Page(
                data = response.metadata.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (endOfPaginationReached) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }
}