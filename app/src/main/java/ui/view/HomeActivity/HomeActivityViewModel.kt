package ui.view.HomeActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.model.room.entities.listaDeListas
import domain.interactors.homeActivity.InteractorHomeActivity
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


class HomeActivityViewModel @Inject constructor(
        val interactorHomeActivity: InteractorHomeActivity
) : ViewModel() {

        var recycler = MutableLiveData<List<listaDeListas>>()

        suspend fun launchRecyclerLiveData(){
                coroutineScope {
                        var recyclerViewModel  = interactorHomeActivity.ObtenerDatosParaRecyclerView()
                        recycler.postValue(recyclerViewModel)
                }
        }


}