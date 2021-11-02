package data.model.room.dao

import androidx.room.*
import data.model.room.entities.lista

@Dao
interface listaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(lista: lista)


    @Query("UPDATE lista SET nombre = :nombre, contenido = :contenido, pathImage = :imagenPath, backgroundColor= :backgroundPath , lastDate = :fecha , pass = :pass  WHERE id = :identificador")
    suspend fun modificarList(identificador:Int,nombre:String,contenido:String,imagenPath:Int,backgroundPath:Int,fecha: String,pass:String)

    @Delete
    suspend fun deleteList(lista: lista)

    @Query("SELECT * FROM lista WHERE id = :id")
    suspend fun buscarList(id: Int) : lista

    @Query("DELETE FROM lista WHERE id = :contact_id")
    suspend fun deleteListById(contact_id: Int)

}