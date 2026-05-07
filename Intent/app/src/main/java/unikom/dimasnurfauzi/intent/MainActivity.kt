package unikom.dimasnurfauzi.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
* Nama  : Dimas Nurfauzi
* NIM   : 10123914
* Kelas : IF12
* */

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMove: Button = findViewById(R.id.btn_move)
        btnMove.setOnClickListener(this)

        val btnData: Button = findViewById(R.id.btn_data)
        btnData.setOnClickListener(this)

        val btnObject: Button = findViewById(R.id.btn_object)
        btnObject.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move -> {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_data -> {
                val intent = Intent(this@MainActivity, DataActivity::class.java)
                intent.putExtra(DataActivity.EXTRA_NAME, "Dimas Nurfauzi")
                intent.putExtra(DataActivity.EXTRA_AGE, 24)
                startActivity(intent)
            }

            R.id.btn_object -> {
                val person = Person(
                    "Dimas Nurfauzi",
                    24,
                    "dimasnurfauzi@unikom.com",
                    "Bandung"
                )

                val intent = Intent(this@MainActivity, ObjectActivity::class.java)
                intent.putExtra(ObjectActivity.EXTRA_PERSON, person)
                startActivity(intent)
            }
        }
    }
}