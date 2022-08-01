
package android.ptc.com.ptcflixing.persistence

import android.ptc.com.ptcflixing.data.local.JumiaDatabase
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class LocalDatabase {
  lateinit var db: JumiaDatabase

  @Before
  fun initDB() {
    db = Room.inMemoryDatabaseBuilder(getApplicationContext(), JumiaDatabase::class.java)
      .allowMainThreadQueries()
      .build()
  }

  @After
  fun closeDB() {
    db.close()
  }
}
