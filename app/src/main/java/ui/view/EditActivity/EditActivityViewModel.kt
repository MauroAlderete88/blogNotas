package ui.view.EditActivity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.model.room.entities.lista
import domain.interactors.EditActivity.InteractorEditActivityImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditActivityViewModel @ViewModelInject constructor(
        val interactorEditActivity: InteractorEditActivityImp,
        @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var resultado = MutableLiveData<Boolean>()
    var resultadoUpdate = MutableLiveData<Boolean>()
    val resultadoList = MutableLiveData<lista>()

   suspend fun crearLista(titulo : String , contenido : String , imagen : Int , color : Int , pass : String){
   val resultadoOperacion = interactorEditActivity.guardarNuevaLista(titulo, contenido,imagen,color,pass)
   resultado.postValue(resultadoOperacion)
   }

   suspend fun UpdateList(identificador : Int ,titulo : String , contenido : String , imagen : Int , color : Int , pass : String){
   val resultado = interactorEditActivity.modificarLista(identificador, titulo, contenido, imagen, color, pass)
   resultadoUpdate.postValue(resultado)
   }

    fun cargarLista(id : Int){
        viewModelScope.launch (Dispatchers.IO){
            val resultado = interactorEditActivity.cargarLista(id)
                resultadoList.postValue(resultado)
        }
    }
}