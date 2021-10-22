package data.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import data.model.room.dao.listaDao
import data.model.room.dao.listaDeListasDao
import data.model.room.dao.pathImageDao
import data.model.room.entities.lista
import data.model.room.entities.listaDeListas
import data.model.room.entities.pathImage
import data.model.room.entities.pathStyleGradients

@Database(
    entities = [listaDeListas::class , lista::class, pathImage::class, pathStyleGradients::class],
    version = 2
)

abstract class listDB : RoomDatabase() {


    abstract fun listaDao():listaDao
    abstract fun listaDeListasDao():listaDeListasDao
    abstract fun pathImageDao():pathImageDao

}