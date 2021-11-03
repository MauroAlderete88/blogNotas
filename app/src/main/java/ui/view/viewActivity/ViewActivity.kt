package ui.view.viewActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.blognotas.R
import com.example.blognotas.databinding.HomeActivityBinding
import com.example.blognotas.databinding.ViewActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.view.EditActivity.EditActivity

@AndroidEntryPoint
class ViewActivity : AppCompatActivity() {
    private  val  viewmodel : ViewActivityViewModel by viewModels()
    lateinit var binding: ViewActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        var identificador : Int? = bundle?.getInt("identificador")


                viewmodel.cargarLista(identificador!!)

                viewmodel.resultadoList.observe(this,{
                   identificador=it.id
                   binding.ivIconViewActivity.setImageResource(it.pathImage)
                   binding.txTituloViewactivity.setText(it.nombre)
                   binding.banner.setBackgroundResource(it.backgroundColor)
                   binding.multilinea.setText(it.contenido)
                })

                viewmodel.resultadoBorrado.observe(this,{
                    if (it==true){
                        finish()
                    }
                })


              binding.bEditar.setOnClickListener {
                   val intent = Intent(this, EditActivity::class.java)
                   intent.putExtra("id",identificador?:0)
                   intent.putExtra("bandera",true)
                   startActivity(intent)
              }

              binding.bEliminar.setOnClickListener {
                   viewmodel.eliminarLista(identificador!!)
              }

        //refresh
        binding.swipeRefresh.setOnRefreshListener {
            this.recreate()
            binding.swipeRefresh.isRefreshing = false
        }



    }




}