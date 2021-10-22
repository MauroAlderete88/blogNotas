package data.model.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import data.model.room.entities.listaDeListas

@Dao
interface listaDeListasDao   {

    @Query("SELECT * from listaDeListas")

    fun getListas():List<listaDeListas>

    @Update
     fun update(item:listaDeListas)

    @Delete
     fun delete(item:listaDeListas)
}