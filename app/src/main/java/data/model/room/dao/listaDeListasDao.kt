package data.model.room.dao

import androidx.room.*
import data.model.room.entities.listaDeListas

@Dao
interface listaDeListasDao   {

    @Query("SELECT * from listaDeListas")

    fun getListas():List<listaDeListas>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLista(item:listaDeListas)

    @Update
     fun update(item:listaDeListas)

}