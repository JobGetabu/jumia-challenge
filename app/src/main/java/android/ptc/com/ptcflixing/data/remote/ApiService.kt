package android.ptc.com.ptcflixing.data.remote

import android.ptc.com.ptcflixing.model.configurations.Configurations
import android.ptc.com.ptcflixing.model.product.ProductResponse
import android.ptc.com.ptcflixing.model.search.SearchResult
//import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("configurations/")
    suspend fun getConfigurations(): Response<Configurations>

    @GET("search/{search}/page/{page}/")
    suspend fun searchProduct(
        @Path("page") page: Int,
        @Path("search") query: String
    ): SearchResult

    @GET("product/{sku}/")
    suspend fun getProduct(
        @Path("sku") sku: Int,
    ): Response<ProductResponse>

}