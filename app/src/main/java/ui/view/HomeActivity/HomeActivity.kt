package ui.view.HomeActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.example.blognotas.R
import com.example.blognotas.databinding.HomeActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import data.enumStyleColors.colores
import data.enumStyleColors.providerStyle
import data.model.room.dao.pathImageDao
import data.model.room.entities.pathImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ui.view.EditActivity.EditActivity
import javax.inject.Inject



@AndroidEntryPoint
class HomeActivity() : AppCompatActivity() {
    @Inject lateinit var  ruta : pathImageDao
    @Inject lateinit var styles : providerStyle

     private val viewModel: HomeActivityViewModel by viewModels()
     private lateinit var binding : HomeActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.nuevaLista.setOnClickListener {
            val intent = Intent(this,EditActivity::class.java)
            startActivity(intent)
        }
    }

    /*
//SACAR DESPUES
//Metodo que ejecuta el guardado de imagenes en bd.Se usa una sola vez cuando se crea la bd.
private fun inicialityImagePath () {
    lifecycleScope.launch{
        val result = withContext(Dispatchers.IO){
            ruta.insert(pathImage(0,"CARACOL", "drawable-mdpi/caracol"))
            ruta.insert(pathImage(0,"CIERVO", "drawable-mdpi/ciervo"))
            ruta.insert(pathImage(0,"CONEJO", "drawable-mdpi/conejo"))
            ruta.insert(pathImage(0,"ELEFANTE", "drawable-mdpi/elefante"))
            ruta.insert(pathImage(0,"FLAMENCO", "drawable-mdpi/flamenco"))
            ruta.insert(pathImage(0,"GALLINA", "drawable-mdpi/gallina"))
            ruta.insert(pathImage(0,"JIRAFA", "drawable-mdpi/jirafa"))
            ruta.insert(pathImage(0,"LANGOSTA", "drawable-mdpi/langosta"))
            ruta.insert(pathImage(0,"LLAMA", "drawable-mdpi/llama"))
            ruta.insert(pathImage(0,"MURCIELAGO", "drawable-mdpi/murcielago"))
            ruta.insert(pathImage(0,"PAJARO", "drawable-mdpi/pajaro"))
            ruta.insert(pathImage(0,"RINOCERONTE", "drawable-mdpi/rinoceronte"))
            ruta.insert(pathImage(0,"SERPIENTE", "drawable-mdpi/serpiente"))
            ruta.insert(pathImage(0,"TORO", "drawable-mdpi/toro"))
            ruta.insert(pathImage(0,"TORTUGA", "drawable-mdpi/tortuga"))
            ruta.insert(pathImage(0,"TUCAN", "drawable-mdpi/tucan"))
            ruta.insert(pathImage(0,"VACA", "drawable-mdpi/vaca"))
            ruta.insert(pathImage(0,"ZORRO", "drawable-mdpi/zorro"))
        }

    }
}

 */
}

