package ui.view.EditActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.interactors.EditActivity.InteractorEditActivityImp
import javax.inject.Inject

class EditActivityViewModel @Inject constructor(
        val interactorEditActivity: InteractorEditActivityImp
) : ViewModel() {

    var resultado = MutableLiveData<Boolean>()


   suspend fun crearLista(titulo : String , contenido : String , imagen : String , color : String , pass : String){
            val resultadoOperacion = interactorEditActivity.guardarNuevaLista(titulo, contenido,imagen,color,pass)
            resultado.postValue(resultadoOperacion)
    }
}