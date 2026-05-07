package unikom.dimasnurfauzi.intent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ObjectActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)

        val txtObject: TextView = findViewById(R.id.text_object)
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name}, \nEmail : ${person.email}, \nAge : ${person.age}, \nLocation : ${person.city}"
        txtObject.text = text
    }
}