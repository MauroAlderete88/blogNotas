package ui.view.EditActivity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import domain.interactors.EditActivity.InteractorEditActivityImp

class EditActivityViewModel @ViewModelInject constructor(
        val interactorEditActivity: InteractorEditActivityImp,
        @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var resultado = MutableLiveData<Boolean>()


   suspend fun crearLista(titulo : String , contenido : String , imagen : Int , color : Int , pass : String){
            val resultadoOperacion = interactorEditActivity.guardarNuevaLista(titulo, contenido,imagen,color,pass)
            resultado.postValue(resultadoOperacion)
    }
}