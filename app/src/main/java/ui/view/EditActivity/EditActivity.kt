package ui.view.EditActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.blognotas.R
import com.example.blognotas.databinding.EditActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ui.view.EditActivity.adaptersSpinner.adapterSpinnerDegradeBackground
import ui.view.EditActivity.adaptersSpinner.adapterSpinnerImages
import ui.view.EditActivity.providers.providersGradientBackground
import ui.view.EditActivity.providers.providersImages
import ui.view.HomeActivity.HomeActivity
import javax.inject.Inject


@AndroidEntryPoint
class EditActivity() : AppCompatActivity() {

    private  val editmodel : EditActivityViewModel by viewModels()
    @Inject lateinit var providersGradient : providersGradientBackground
    @Inject lateinit var providersImages: providersImages

    //Si viene desde viewActivity cambiar a true. El default sera false.
    var banderaBoolean : Boolean =false
    var identificador : Int = 0

    lateinit var binding: EditActivityBinding
    var iconoElejido:Int = R.drawable.aleatorio_image
    var background:Int = R.drawable.grandient_01_cardview


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EditActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

       if (banderaBoolean==true){
           val extras = intent.extras
           identificador= extras?.getInt("identificador")!!
       }


        //Spinner icons
        val adapterSpinnerImages = adapterSpinnerImages(this, providersImages.getList())
        binding.SpinnerImage.adapter = adapterSpinnerImages

        //Spinner degrade
        val adapterSpinnerGradient = adapterSpinnerDegradeBackground(this,providersGradient.getList())
        binding.SpinnerGradient.adapter = adapterSpinnerGradient

        //Evento del spinner iconos
        binding.SpinnerImage.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                iconoElejido = selectedItem.hashCode()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //null
            }

        }

        //Evento del spinner gradient
        binding.SpinnerGradient.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                background = selectedItem.hashCode()

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //null
            }

        }

        //Evento de boton guardar
        binding.bGuardar.setOnClickListener {
            lifecycleScope.launch{
                   checksNuls(binding.etTitulo.text.toString(),
                            binding.contenido.text.toString(),
                            iconoElejido,
                            background,
                           ""
                    )
            }
        }



        //Observers
        editmodel.resultado.observe(this,{
            if (it==true){
                val goHome = Intent (this,HomeActivity::class.java)
                startActivity(goHome)
                finish()
            }
        })



    }



       private suspend fun checksNuls(titulo : String, contenido : String, imagen : Int, color : Int, pass : String ){
           if (binding.etTitulo.text.toString().equals("")){
               Toast.makeText(this,"Es necesario agregar un titulo.", Toast.LENGTH_SHORT).show()
           } else {
              //Aca se envian al viewModel
              editmodel.crearLista(titulo , contenido , imagen , color , pass )
           }
       }

}