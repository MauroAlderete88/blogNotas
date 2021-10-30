package domain.interactors.homeActivity

import android.graphics.drawable.Drawable
import data.model.room.dataBaseProvider
import data.model.room.entities.listaDeListas


import data.repository.repositoryRoom
import javax.inject.Inject


class InteractorHomeActivityImp @Inject constructor(
        val dataBaseProvider: dataBaseProvider
):InteractorHomeActivity {

    override suspend fun obtenerDatosSegunListaTouch(id:Int) {
        dataBaseProvider.mostrarLista(id)
    }

    override suspend fun ObtenerDatosParaRecyclerView() : List<listaDeListas> {
      val resultado = dataBaseProvider.mostrarListas()
      return resultado
    }

    override suspend fun obtenerImagenDrawable(nombre: String): Drawable {
        return TODO()
    }


}