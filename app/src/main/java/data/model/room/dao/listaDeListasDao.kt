package data.model.room.dao

import androidx.room.*
import data.model.room.entities.listaDeListas

@Dao
interface listaDeListasDao {

    @Query("SELECT * from listaDeListas")

    fun getListas():List<listaDeListas>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLista(item: listaDeListas)

     @Delete
     fun delete(item: listaDeListas)

    @Query("UPDATE listaDeListas SET nombreLista = :titulo, pathImage = :imagenPath, background_path_gradient= :backgroundPath WHERE id = :id")
    fun update(id: Int,titulo: String, imagenPath: Int, backgroundPath: Int)

    @Query("DELETE FROM listaDeListas WHERE id = :contact_id")
    suspend fun deletelistadelistasById(contact_id: Int)

}