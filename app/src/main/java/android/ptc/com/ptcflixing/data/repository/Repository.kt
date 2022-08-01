package android.ptc.com.ptcflixing.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import android.ptc.com.ptcflixing.data.local.JumiaDatabase
import android.ptc.com.ptcflixing.data.paging.ProductsSource
import android.ptc.com.ptcflixing.data.remote.ApiService
import android.ptc.com.ptcflixing.model.configurations.Configurations
import android.ptc.com.ptcflixing.model.search.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val apiService: ApiService,
    private val jumiaDatabase: JumiaDatabase
) {

    fun searchProducts(repository: Repository, query: String): Flow<PagingData<Result>>{
        val products: Flow<PagingData<Result>> = Pager(PagingConfig(pageSize = 20)) {
            ProductsSource(repository, query)
        }.flow
        return products
    }

    suspend fun searchProducts(query: String, pageNumber: Int)  =
        apiService.searchProduct(pageNumber, query)


    val readConfigurations: Flow<Configurations> =  jumiaDatabase.configurationsDao().readConfigurations()

    suspend fun cacheConfigurations(response: Configurations): Long {
        jumiaDatabase.configurationsDao().deleteConfigurations()
         return jumiaDatabase.configurationsDao().insertConfigurations(response)
    }

    suspend fun getConfigurations() = apiService.getConfigurations()

    suspend fun getProductDetails(sku: Int) = apiService.getProduct(sku)



}