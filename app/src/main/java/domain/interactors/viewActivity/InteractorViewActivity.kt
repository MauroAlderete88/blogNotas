package domain.interactors.viewActivity

import data.model.room.entities.lista

interface InteractorViewActivity {
    suspend fun cargaLista(id : Int): lista
    suspend fun eliminarLista(lista: lista):Boolean
    suspend fun modificar()

}