package ui.view.EditActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blognotas.R
import dagger.hilt.android.AndroidEntryPoint

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_activity)
    }
}