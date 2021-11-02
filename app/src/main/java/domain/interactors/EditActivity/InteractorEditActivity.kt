package domain.interactors.EditActivity

import data.model.room.entities.lista

interface InteractorEditActivity {

    suspend fun guardarNuevaLista(titulo : String , contenido : String , imagen : Int , color : Int , pass : String) : Boolean

    suspend fun modificarLista(identificador: Int ,titulo : String , contenido : String , imagen : Int , color : Int , pass : String) : Boolean

   suspend fun cargarLista(id : Int) : lista

}