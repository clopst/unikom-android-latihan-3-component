package unikom.dimasnurfauzi.formfgd

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import unikom.dimasnurfauzi.formfgd.databinding.ActivityMainBinding
import unikom.dimasnurfauzi.formfgd.model.Participant

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val categories = listOf(
        "Akademisi",
        "Bisnis",
        "Komunitas",
        "Pemerintah",
        "Media",
        "Organisasi",
        "NGO"
    )

    private val skillMap by lazy {
        listOf(
            Pair(binding.chkAlgoritma, "Algoritma"),
            Pair(binding.chkProblemSolving, "Problem Solving"),
            Pair(binding.chkProgramming, "Programming"),
            Pair(binding.chkDecisionThinking, "Decision Thinking"),
            Pair(binding.chkCriticalThinking, "Critical Thinking")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategory.adapter = adapter

        binding.btnSubmit.setOnClickListener {
            val name = binding.editName.text.toString()
            val phone = binding.editPhone.text.toString()
            val email = binding.editEmail.text.toString()
            val gender = when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radio_male -> "Laki-laki"
                R.id.radio_female -> "Perempuan"
                else -> ""
            }

            val skillset = skillMap.filter { it.first.isChecked }.map { it.second }
            if (skillset.isEmpty()) {
                Toast.makeText(this, "Pilih minimal satu skill", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val category = binding.spinnerCategory.selectedItem.toString()

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val participant = Participant(name, phone, email, gender, skillset, category)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PARTICIPANT, participant)
            startActivity(intent)
        }
    }

}
