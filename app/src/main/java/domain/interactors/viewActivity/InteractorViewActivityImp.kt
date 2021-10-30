package domain.interactors.viewActivity

import data.model.room.entities.lista
import javax.inject.Inject

class InteractorViewActivityImp @Inject constructor(): InteractorViewActivity {

    val dataBaseProvider = data.model.room.dataBaseProvider()

     override suspend fun cargaLista(id: Int) : lista {
         return dataBaseProvider.mostrarLista(id)
    }

    override suspend fun eliminarLista(lista: lista): Boolean {
       val resultado = dataBaseProvider.eliminarListaPorID(lista)
       return resultado
    }

    override suspend fun modificar() {

    }
}