package ui.view.viewActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blognotas.R
import dagger.hilt.android.AndroidEntryPoint


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity)
    }
}