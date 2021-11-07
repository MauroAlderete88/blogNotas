package ui.view.EditActivity.providers

import com.example.blognotas.R
import ui.view.EditActivity.adaptersSpinner.spinnerGradient
import javax.inject.Inject

class providersGradientBackground @Inject constructor() {

    companion object{
        val listado : List<spinnerGradient> = listOf(
            spinnerGradient(R.drawable.gradient_01_background),
            spinnerGradient(R.drawable.gradient_02_background),
            spinnerGradient(R.drawable.gradient_03_background),
            spinnerGradient(R.drawable.gradient_04_background),
            spinnerGradient(R.drawable.gradient_05_background)
        )
    }

    fun getList () : List<spinnerGradient> {
        return listado
    }

    fun getPosition (gradient : Int) : Int{
        return listado.indexOf(spinnerGradient(gradient))
    }

}