package unikom.dimasnurfauzi.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
* Nama  : Dimas Nurfauzi
* NIM   : 10123914
* Kelas : IF12
* */

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtResultValue: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == InputActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getStringExtra(InputActivity.EXTRA_SELECTED_VALUE)
            txtResultValue.text = "Jenis Kelamin Anda : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMove: Button = findViewById(R.id.btn_move)
        btnMove.setOnClickListener(this)

        val btnData: Button = findViewById(R.id.btn_data)
        btnData.setOnClickListener(this)

        val btnObject: Button = findViewById(R.id.btn_object)
        btnObject.setOnClickListener(this)

        val btnDial: Button = findViewById(R.id.btn_dial)
        btnDial.setOnClickListener(this)

        val btnApp: Button = findViewById(R.id.btn_app)
        btnApp.setOnClickListener(this)

        val btnInput: Button = findViewById(R.id.btn_input)
        btnInput.setOnClickListener(this)

        txtResultValue = findViewById(R.id.txt_result)
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

            R.id.btn_dial -> {
                val phoneNumber = "08123456789"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_app -> {
                val openAnotherApp = Intent(Intent.ACTION_MAIN)
                openAnotherApp.setPackage("com.google.android.youtube")
                startActivity(openAnotherApp)
            }

            R.id.btn_input -> {
                val intent = Intent(this@MainActivity, InputActivity::class.java)
                resultLauncher.launch(intent)
            }
        }
    }
}