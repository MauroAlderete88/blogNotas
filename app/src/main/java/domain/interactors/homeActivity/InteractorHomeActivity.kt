package domain.interactors.homeActivity

import android.content.Context
import android.graphics.drawable.Drawable
import data.model.room.entities.listaDeListas

interface InteractorHomeActivity  {

    //  --->
   suspend fun obtenerDatosSegunListaTouch(id:Int)

    //  <---
    suspend fun ObtenerDatosParaRecyclerView():List<listaDeListas>
    suspend fun obtenerImagenDrawable(nombre:String) :Drawable
}