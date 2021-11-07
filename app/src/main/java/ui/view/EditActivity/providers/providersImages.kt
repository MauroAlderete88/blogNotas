package ui.view.EditActivity.providers

import com.example.blognotas.R
import ui.view.EditActivity.adaptersSpinner.spinnerImage
import javax.inject.Inject

class providersImages @Inject constructor() {
    companion object {
        val listadoDeIconos : List<spinnerImage> = listOf(
                spinnerImage(R.drawable.indio),
                spinnerImage(R.drawable.pina),
                spinnerImage(R.drawable.bull),
                spinnerImage(R.drawable.pluma),
                spinnerImage(R.drawable.luces),
                spinnerImage(R.drawable.hombre),
                spinnerImage(R.drawable.avion),
                spinnerImage(R.drawable.palmera),
                spinnerImage(R.drawable.calavera),
                spinnerImage(R.drawable.coco),
                spinnerImage(R.drawable.ruta)
        )


    }

    fun getList() : List<spinnerImage>{
        return listadoDeIconos
    }

    fun getPosition (valor : Int) : Int{
       return listadoDeIconos.indexOf(spinnerImage(valor))
    }

}