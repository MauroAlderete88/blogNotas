package ui.view.viewActivity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.model.room.entities.lista
import domain.interactors.viewActivity.InteractorViewActivityImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewActivityViewModel @ViewModelInject constructor(
        val interactorViewActivity: InteractorViewActivityImp

) : ViewModel() {

    val resultadoList = MutableLiveData<lista>()

    fun cargarLista(id : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val resultado = interactorViewActivity.cargaLista(id)
                resultadoList.postValue(resultado)
            }
        }
    }



}