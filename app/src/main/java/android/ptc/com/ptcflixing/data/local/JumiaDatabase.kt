package android.ptc.com.ptcflixing.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import android.ptc.com.ptcflixing.data.local.dao.ConfigurationsDao
import android.ptc.com.ptcflixing.model.configurations.Configurations

@Database(entities = [Configurations::class], version = 1)
abstract class JumiaDatabase : RoomDatabase() {

    abstract fun configurationsDao(): ConfigurationsDao

}