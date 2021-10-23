package data.enumStyleColors

import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.blognotas.R
import ui.view.HomeActivity.HomeActivity
import javax.inject.Inject

class providerStyle @Inject constructor() {

    fun insertResourceID_cardView(colores: colores, layout: ConstraintLayout){
        when(colores){
            data.enumStyleColors.colores.VIOLETA ->layout.setBackgroundResource(R.drawable.grandient_01_cardview)
            data.enumStyleColors.colores.VERDE ->layout.setBackgroundResource(R.drawable.gradient_02_cardview)
            data.enumStyleColors.colores.CELESTE ->layout.setBackgroundResource(R.drawable.gradient_03_cardview)
            data.enumStyleColors.colores.NARANJA ->layout.setBackgroundResource(R.drawable.gradient_04_cardview)
            data.enumStyleColors.colores.AZUL ->layout.setBackgroundResource(R.drawable.gradient_05_cardview)
        }
    }

    fun insertResourceIDBackground(colores: colores, layout: ConstraintLayout) : ConstraintLayout{
        when(colores){
            data.enumStyleColors.colores.VIOLETA ->layout.setBackgroundResource(R.drawable.gradient_01_background)
            data.enumStyleColors.colores.VERDE ->layout.setBackgroundResource(R.drawable.gradient_02_background)
            data.enumStyleColors.colores.CELESTE ->layout.setBackgroundResource(R.drawable.gradient_03_background)
            data.enumStyleColors.colores.NARANJA ->layout.setBackgroundResource(R.drawable.gradient_04_background)
            data.enumStyleColors.colores.AZUL ->layout.setBackgroundResource(R.drawable.gradient_05_background)
        }
        return layout
    }


}