package di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.enumStyleColors.colores
import data.model.room.listDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object roomModule {

    @Singleton
    @Provides
    fun RoomInstance(
        @ApplicationContext context : Context
    ) = Room.databaseBuilder(context,listDB::class.java, "listas").build()


    @Singleton
    @Provides
    fun provideListaDao(db : listDB) = db.listaDao()

    @Singleton
    @Provides
    fun provideListaDeListaDao (db : listDB) = db.listaDeListasDao()


    @Singleton
    @Provides
    fun pathImageDao(db: listDB) = db.pathImageDao()

}