package android.ptc.com.ptcflixing.di

import android.content.Context
import androidx.room.Room
import android.ptc.com.ptcflixing.data.local.JumiaDatabase
import android.ptc.com.ptcflixing.util.Constants.JUMIA_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): JumiaDatabase {
        return Room.databaseBuilder(
            context,
            JumiaDatabase::class.java,
            JUMIA_DATABASE
        ).build()
    }

}