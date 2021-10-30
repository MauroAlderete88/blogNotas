package ui.view.EditActivity.adaptersSpinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.blognotas.R

class adapterSpinnerDegradeBackground(contexto: Context, lista: List<spinnerGradient>):ArrayAdapter<spinnerGradient>
    (contexto,0,lista) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView( position: Int, convertView: View?, parent: ViewGroup) : View{
        val imagen = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_background_gradient, parent, false)
        var iconImage = view.findViewById<ImageView>(R.id.gradientSpinner)
        iconImage.setImageResource(imagen!!.imagen)
        return view
    }
}