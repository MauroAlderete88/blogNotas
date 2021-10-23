package domain.interactors.EditActivity

import data.model.room.dataBaseProvider
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class InteractorEditActivityImp @Inject constructor(
        val dataBaseProvider: dataBaseProvider
) : InteractorEditActivity {



    override suspend fun guardarNuevaLista(titulo : String , contenido : String , imagen : String , color : String , pass : String): Boolean {
        val formato = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val fechaAct = formato.format(Date())
        val resultado = dataBaseProvider.nuevaLista(titulo,contenido,imagen,color,fechaAct,pass)
        return resultado
    }

    override suspend fun modificarLista(int: Int): Boolean {
        TODO("Not yet implemented")
    }
}