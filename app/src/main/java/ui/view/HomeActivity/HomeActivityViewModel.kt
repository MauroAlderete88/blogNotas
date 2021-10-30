package ui.view.HomeActivity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.model.room.entities.listaDeListas
import domain.interactors.homeActivity.InteractorHomeActivity
import domain.interactors.homeActivity.InteractorHomeActivityImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class HomeActivityViewModel @ViewModelInject constructor(
        private val interactorHomeActivity: InteractorHomeActivityImp
) : ViewModel() {

        val listaRecycler = MutableLiveData<List<listaDeListas>>()

        fun ejecutarRecycler(){
            viewModelScope.launch {
                withContext(Dispatchers.IO){
                    val resultado = interactorHomeActivity.ObtenerDatosParaRecyclerView()
                    listaRecycler.postValue(resultado)
                }
            }
        }



}