package unikom.dimasnurfauzi.viewbinding

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import unikom.dimasnurfauzi.viewbinding.databinding.ActivityMainBinding

/*
* NIM   : 10123914
* Nama  : Dimas Nurfauzi
* Kelas : IF12
* */

class MainActivity : AppCompatActivity() {
//    private lateinit var editNim: EditText
//    private lateinit var editNama: EditText
//    private lateinit var btnSave: Button
//    private lateinit var txtNim: TextView
//    private lateinit var txtNama: TextView

    private lateinit var binding: ActivityMainBinding

    var nim: String = ""
    var nama: String = ""
    var mahasiswa: Mahasiswa = Mahasiswa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSave.setOnClickListener {
            nim = binding.editNim.text.toString()
            nama = binding.editNama.text.toString()
            mahasiswa.nim = nim
            mahasiswa.nama = nama

            binding.mahasiswa = mahasiswa

//            binding.txtNim.text = "NIM: " + nim
//            binding.txtNama.text = "Nama: " + nama
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
        }

//        editNim = findViewById(R.id.edit_nim)
//        editNama = findViewById(R.id.edit_nama)
//        btnSave = findViewById(R.id.btn_save)
//        txtNim = findViewById(R.id.txt_nim)
//        txtNama = findViewById(R.id.txt_nama)

//        btnSave.setOnClickListener {
//            nim = editNim.text.toString()
//            nama = editNama.text.toString()
//            txtNim.text = "NIM: " + nim
//            txtNama.text = "Nama: " + nama
//            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
//        }
    }
}