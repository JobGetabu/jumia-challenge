@file:OptIn(ExperimentalPagingApi::class, ExperimentalCoroutinesApi::class)

package android.ptc.com.ptcflixing.ui

import android.ptc.com.ptcflixing.data.remote.Resource
import android.ptc.com.ptcflixing.data.repository.Repository
import android.ptc.com.ptcflixing.screens.details.DetailsViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.ExperimentalPagingApi
import android.ptc.com.ptcflixing.MockData
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import retrofit2.Response


class DetailsViewModelTest {
    @OptIn(ExperimentalPagingApi::class)
    var detailsViewModel: DetailsViewModel? = null

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @MockK
    lateinit var repository: Repository


    @Before()
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        detailsViewModel = DetailsViewModel(repository)

    }

    @After
    fun destroy() {
        detailsViewModel = null
    }

    @Test
    fun get_UserCase_with_valid_sku_return_product_result() {
        runTest {
            coEvery {
                repository.getProductDetails(1)
            }returns Response.success(MockData.product)
        }
        detailsViewModel?.getProduct(1)

        val result = detailsViewModel?.productLiveData?.value

        assertThat(result).isEqualTo(
            Resource.loading(result)
        )

        val result2 = detailsViewModel?.productLiveData?.value

        assertThat(result2).isEqualTo(
            Resource.success(MockData.product)
        )

    }
}