package data.model.room.dao

import androidx.room.*
import data.model.room.entities.lista

@Dao
interface listaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(lista: lista)

    @Update
    suspend fun updateList(lista: lista)

    @Delete
    suspend fun deleteList(lista: lista)

    @Query("SELECT * FROM lista WHERE id = :id")
    suspend fun buscarList(id:Int) : lista

}