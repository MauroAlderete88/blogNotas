package domain.interactors.viewActivity

import android.widget.Toast
import com.example.blognotas.R
import data.model.room.dataBaseProvider
import data.model.room.entities.lista
import javax.inject.Inject

class InteractorViewActivityImp @Inject constructor(
        val dataBaseProvider: dataBaseProvider
): InteractorViewActivity {

     override suspend fun cargaLista(id: Int) :lista  {
        return dataBaseProvider.mostrarLista(id)
    }

    override suspend fun eliminarLista(identificador:Int): Boolean {
       val resultado = dataBaseProvider.eliminarListaPorID(identificador)
        if (resultado==true){ dataBaseProvider.eliminarListadeListas(identificador) }
        return resultado
    }

    override suspend fun modificar() {

    }
}