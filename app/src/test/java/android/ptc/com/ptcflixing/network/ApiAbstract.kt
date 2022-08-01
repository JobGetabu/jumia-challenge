
package android.ptc.com.ptcflixing.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

@RunWith(JUnit4::class)
abstract class ApiAbstract<T> {

  @Rule
  @JvmField
  val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

  lateinit var mockWebServer: MockWebServer

  @Throws(IOException::class)
  @Before
  fun mockServer() {
    mockWebServer = MockWebServer()
    mockWebServer.start()
  }

  @Throws(IOException::class)
  @After
  fun stopServer() {
    mockWebServer.shutdown()
  }

  fun createService(clazz: Class<T>): T {
    return Retrofit.Builder()
      .baseUrl(mockWebServer.url("/"))
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(clazz)
  }
}
