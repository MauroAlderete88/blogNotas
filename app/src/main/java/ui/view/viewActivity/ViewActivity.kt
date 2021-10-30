package ui.view.viewActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        var identificador = bundle?.getInt("identificador")
        viewmodel.cargarLista(1)

                viewmodel.resultadoList.observe(this,{
                   identificador=it.id
                   binding.ivIconViewActivity.setImageResource(it.pathImage)
                   binding.txTituloViewactivity.setText(it.nombre)
                   binding.banner.setBackgroundResource(it.backgroundColor)
                   binding.multilinea.setText(it.contenido)
                })


               binding.bEditar.setOnClickListener {
                   val intent = Intent(this, EditActivity::class.java)
                   intent.putExtra("id" , identificador )
                   startActivity(intent)
                   finish()}


    }



    private fun cargadoLista(){

    }

}