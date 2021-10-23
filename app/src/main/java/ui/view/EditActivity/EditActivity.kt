package ui.view.EditActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.blognotas.databinding.EditActivityBinding
import data.enumStyleColors.colores
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ui.view.HomeActivity.HomeActivity

class EditActivity : AppCompatActivity() {

    private val editmodel : EditActivityViewModel by viewModels()
    lateinit var binding: EditActivityBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EditActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bGuardar.setOnClickListener {

            lifecycleScope.launch{
                    checksNuls(binding.etTitulo.text.toString(),
                            binding.contenido.text.toString(),
                            "@drawable-mdpi/ardilla",
                            colores.NARANJA.name
                            ,""
                    )

            }

        }

        editmodel.resultado.observe(this,{
            if (it==true){
                //En realidad iria al view activity pero como no lo cree todavia va a uno cualquiera

            }
        })


    }
       private suspend fun checksNuls(titulo : String, contenido : String, imagen : String, color : String, pass : String ){
           if (binding.etTitulo.text.toString().equals("")){
               Toast.makeText(this,"Es necesario agregar un titulo.", Toast.LENGTH_SHORT).show()
           } else {
              //Aca se envian al viewModel
               editmodel.crearLista(titulo , contenido , imagen , color , pass )
           }
       }

}