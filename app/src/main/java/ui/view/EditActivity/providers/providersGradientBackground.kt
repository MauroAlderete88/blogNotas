package ui.view.EditActivity.providers

import com.example.blognotas.R
import ui.view.EditActivity.adaptersSpinner.spinnerGradient
import javax.inject.Inject

class providersGradientBackground @Inject constructor() {

    companion object{
        val listado : List<spinnerGradient> = listOf(
            spinnerGradient(R.drawable.grandient_01_cardview),
            spinnerGradient(R.drawable.gradient_02_cardview),
            spinnerGradient(R.drawable.gradient_03_cardview),
            spinnerGradient(R.drawable.gradient_04_cardview),
            spinnerGradient(R.drawable.gradient_05_cardview)
        )
    }

    fun getList () : List<spinnerGradient> {
        return listado
    }

}