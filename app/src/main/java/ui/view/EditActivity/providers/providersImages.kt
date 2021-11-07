package ui.view.EditActivity.providers

import com.example.blognotas.R
import ui.view.EditActivity.adaptersSpinner.spinnerImage
import javax.inject.Inject

class providersImages @Inject constructor() {
    companion object {
        val listadoDeIconos : List<spinnerImage> = listOf(
                spinnerImage(R.drawable.aleatorio_image),
                spinnerImage(R.drawable.indio),
                spinnerImage(R.drawable.pina)
        )


    }

    fun getList() : List<spinnerImage>{
        return listadoDeIconos
    }

    fun getPosition (valor : Int) : Int{
       return listadoDeIconos.indexOf(spinnerImage(valor))
    }

}