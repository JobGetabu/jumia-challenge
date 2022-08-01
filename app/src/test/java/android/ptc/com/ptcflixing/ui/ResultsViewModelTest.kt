@file:OptIn(ExperimentalPagingApi::class, ExperimentalCoroutinesApi::class,
    DelicateCoroutinesApi::class, ExperimentalPagingApi::class, ExperimentalPagingApi::class
)

package android.ptc.com.ptcflixing.ui

import android.ptc.com.ptcflixing.data.remote.ApiService
import android.ptc.com.ptcflixing.data.repository.Repository
import android.ptc.com.ptcflixing.screens.results.ResultsViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.ExperimentalPagingApi
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain


class ResultsViewModelTest {
    @OptIn(ExperimentalPagingApi::class)
    var resultsViewModel: ResultsViewModel? = null

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() 
        mainThreadSurrogate.close()
    }

    @MockK
    lateinit var repository: Repository

    @MockK
    lateinit var apiService: ApiService


    @Before()
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        resultsViewModel = ResultsViewModel(repository)

    }

    @After
    fun destroy() {
        resultsViewModel = null
    }

    @Test
    fun get_UserCase_with_product_search_result() {
        TODO()
    }
}