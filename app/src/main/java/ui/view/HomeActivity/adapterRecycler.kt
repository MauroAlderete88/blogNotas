package ui.view.HomeActivity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.blognotas.R
import data.model.room.entities.listaDeListas
import ui.view.viewActivity.ViewActivity

class adapterRecycler(val lista: List<listaDeListas>) : RecyclerView.Adapter<adapterRecycler.listaHolder>(){

    class listaHolder(view: View):RecyclerView.ViewHolder(view) {

        val background = view.findViewById<ConstraintLayout>(R.id.background)
        var icono= view.findViewById<ImageView>(R.id.iv_icon)
        val titulo = view.findViewById<TextView>(R.id.notaNombre)

        fun render(lista: listaDeListas){
            var color :Int = lista.background_path_gradient
            background.setBackgroundResource(color)
            var icon : Int = lista.pathImage
            icono.setImageDrawable(
                    ContextCompat.getDrawable(
                            this.itemView.context,
                            icon
                    )
            )
            icono.layoutParams.height = 300
            titulo.text = lista.nombreLista
            background.setOnClickListener {
              // Se envia a traves de intent a ViewActivity y hace carga de todoel contenido.
              val intento = Intent(itemView.context,ViewActivity::class.java)
              intento.putExtra("identificador",lista.id)
              itemView.context.startActivity(intento)

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return listaHolder(layoutInflater.inflate(R.layout.item_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: listaHolder, position: Int) {
         holder.render(lista[position])
    }

    override fun getItemCount(): Int = lista.size
}

