
package android.ptc.com.ptcflixing.persistence

import android.ptc.com.ptcflixing.data.local.dao.ConfigurationsDao
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class ConfigurationsDaoTest : LocalDatabase() {

  private lateinit var configurationsDao: ConfigurationsDao

  @Before
  fun init() {
    configurationsDao = db.configurationsDao()
  }

  @Test
  fun insertAndLoadConfigurationsTest() {
      TODO()
      /*= runBlocking {

   val mockData = mockConfigurations()
   configurationsDao.insertConfigurations(mockData)

   val loadFromDB = configurationsDao.readConfigurations()
   assertThat(loadFromDB.toString(), `is`(mockData.toString()))*/

  }


}
