
package android.ptc.com.ptcflixing.network

import android.ptc.com.ptcflixing.data.remote.ApiService
import android.ptc.com.ptcflixing.network.ApiAbstract
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.io.IOException

class ApiServiceTest : ApiAbstract<ApiService>() {

  private lateinit var service: ApiService


  @Before
  fun initService() {
    service = createService(ApiService::class.java)
  }

  @Throws(IOException::class)
  @Test
  fun fetchConfigurationsTest() = runBlocking {
    val response = service.getConfigurations()
    mockWebServer.takeRequest()

    assertThat(response.body()?.success  , `is`(true))
  }
}
