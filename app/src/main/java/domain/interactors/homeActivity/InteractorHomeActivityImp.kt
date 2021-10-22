package domain.interactors.homeActivity

import android.graphics.drawable.Drawable
import data.model.room.entities.listaDeListas


import data.repository.repositoryRoom
import javax.inject.Inject


class InteractorHomeActivityImp @Inject constructor():InteractorHomeActivity {

    lateinit var repositoryRoomHomeActivity : repositoryRoom


    override suspend fun obtenerDatosSegunListaTouch(id:Int) {
        repositoryRoomHomeActivity.mostrarLista(id)
    }

    override suspend fun ObtenerDatosParaRecyclerView() : List<listaDeListas> {
      val resultado = repositoryRoomHomeActivity.mostrarListas()
      return resultado
    }

    override suspend fun obtenerImagenDrawable(nombre: String): Drawable {
        return TODO()
    }


}