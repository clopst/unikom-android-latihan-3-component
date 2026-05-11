package unikom.dimasnurfauzi.pahlawanindonesia

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import unikom.dimasnurfauzi.pahlawanindonesia.model.Hero

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textName = findViewById<TextView>(R.id.text_detail_name)
        val textDescription = findViewById<TextView>(R.id.text_detail_description)
        val imageDetailPhoto = findViewById<ImageView>(R.id.image_detaiL_photo)

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("hero", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("hero")
        }

        if (hero != null) {
            imageDetailPhoto.setImageResource(hero.photo)
            textName.text = hero.name
            textDescription.text = hero.description
        }
    }
}