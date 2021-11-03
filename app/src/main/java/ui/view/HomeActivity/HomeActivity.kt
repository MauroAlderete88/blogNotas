package ui.view.HomeActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.blognotas.databinding.HomeActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.view.EditActivity.EditActivity


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private  val  viewmodel : HomeActivityViewModel by viewModels()
    lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel.ejecutarRecycler()

        viewmodel.listaRecycler.observe(this, {
            binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
            val adapter = adapterRecycler(it)
            binding.recyclerView.adapter = adapter
        })

        binding.nuevaLista.setOnClickListener {
            abrirActivityEdit()
        }

        //refresh
        binding.swipeRefresh.setOnRefreshListener {
            this.recreate()
            binding.swipeRefresh.isRefreshing = false
        }




    }

    fun abrirActivityEdit(){
        val intent = Intent(this, EditActivity::class.java)
        startActivity(intent)

    }



}


