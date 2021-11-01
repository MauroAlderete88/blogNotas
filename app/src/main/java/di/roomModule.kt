package di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.model.room.dao.listaDao
import data.model.room.dao.listaDeListasDao
import data.model.room.listDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object roomModule {

    @Singleton
    @Provides
    fun RoomInstance(
        @ApplicationContext context : Context
    ) = Room.databaseBuilder(context,listDB::class.java, "listas").fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideListDao(db : listDB) : listaDao {
        return db.listaDao()
    }

    @Singleton
    @Provides
    fun provideListaDeListaDao (db : listDB) : listaDeListasDao {
       return db.listaDeListasDao()
    }

}