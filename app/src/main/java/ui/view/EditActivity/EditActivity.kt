package ui.view.EditActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.withCreated
import com.example.blognotas.R
import com.example.blognotas.databinding.EditActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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



    lateinit var binding: EditActivityBinding
    var iconoElejido:Int = R.drawable.aleatorio_image
    var background:Int = R.drawable.grandient_01_cardview

    var banderaBoolean : Boolean? = false
    var identificadorBandera : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EditActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bundle = intent.extras
        identificadorBandera  = bundle?.getInt("id")
        banderaBoolean = bundle?.getBoolean("bandera")

        if (banderaBoolean!=null){
            editmodel.cargarLista(identificadorBandera!!)
            editmodel.resultadoList.observe(
                    this,{
                        binding.etTitulo.setText(it.nombre)
                        binding.contenido.setText(it.contenido)

                    }
            )

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
                updateList(binding.etTitulo.text.toString(),
                        binding.contenido.text.toString(),
                        iconoElejido,
                        background,
                        "")
        }



        //Observers
        editmodel.resultado.observe(this,{
            if (it==true){
                val goHome = Intent (this,HomeActivity::class.java)
                startActivity(goHome)
                finish()
            }
        })

        editmodel.resultadoList.observe(this,{
            binding.etTitulo.setText(it.nombre)
            binding.contenido.setText(it.contenido)
        })


    }

    //Chequea que la lista tenga un titulo. En casao de tener se lo envia al ViewModel.
       private suspend fun checksNuls(titulo : String, contenido : String, imagen : Int, color : Int, pass : String ){
           if (binding.etTitulo.text.toString().equals("")){
               Toast.makeText(this,"Es necesario agregar un titulo.", Toast.LENGTH_SHORT).show()
           } else {
              //Aca se envian al viewModel
              editmodel.crearLista(titulo , contenido , imagen , color , pass )
           }
       }

    //Modifica la lista, siempre comprobando si esta existe o es nueva.
       private fun updateList(titulo : String, contenido : String, imagen : Int, color : Int, pass : String){
          if (banderaBoolean == null){
              lifecycleScope.launch (Dispatchers.IO){
                  checksNuls(titulo, contenido,imagen,color,pass)
              }

          } else{
              lifecycleScope.launch (Dispatchers.IO) {
                  editmodel.UpdateList(identificadorBandera?:0,titulo,contenido,imagen,color,pass)
                  finish()
              }
          }
      }




}