package data.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import data.model.room.dao.listaDao
import data.model.room.dao.listaDeListasDao
import data.model.room.entities.lista
import data.model.room.entities.listaDeListas

@Database(
    entities = [listaDeListas::class , lista::class],
    version = 5
)

abstract class listDB : RoomDatabase() {

    abstract fun listaDao():listaDao
    abstract fun listaDeListasDao():listaDeListasDao


}