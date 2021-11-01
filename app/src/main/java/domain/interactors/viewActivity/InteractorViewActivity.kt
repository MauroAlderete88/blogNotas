package domain.interactors.viewActivity

import androidx.lifecycle.MutableLiveData
import data.model.room.entities.lista

interface InteractorViewActivity {
    suspend fun cargaLista(id : Int): lista
    suspend fun eliminarLista(identificador:Int):Boolean
    suspend fun modificar()

}