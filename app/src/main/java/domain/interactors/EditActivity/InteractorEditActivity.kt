package domain.interactors.EditActivity

interface InteractorEditActivity {

    suspend fun guardarNuevaLista(titulo : String , contenido : String , imagen : Int , color : Int , pass : String) : Boolean

    suspend fun modificarLista(int: Int) : Boolean


}