package unikom.dimasnurfauzi.intent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_AGE = "EXTRA_AGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val txtData: TextView = findViewById(R.id.text_data)
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name, Your Age : $age"
        txtData.text = text
    }
}