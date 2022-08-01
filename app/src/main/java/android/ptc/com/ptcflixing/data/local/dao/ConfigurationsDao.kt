package android.ptc.com.ptcflixing.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import android.ptc.com.ptcflixing.model.configurations.Configurations
import kotlinx.coroutines.flow.Flow

@Dao
interface ConfigurationsDao {

    @Query("SELECT * FROM configurations_table")
    fun readConfigurations(): Flow<Configurations>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfigurations(configurations: Configurations): Long

    @Query("DELETE FROM configurations_table")
    suspend fun deleteConfigurations()

}