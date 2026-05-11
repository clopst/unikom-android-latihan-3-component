package unikom.dimasnurfauzi.formfgd

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import unikom.dimasnurfauzi.formfgd.databinding.ActivityDetailBinding
import unikom.dimasnurfauzi.formfgd.model.Participant

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_PARTICIPANT = "extra_participant"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val participant = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PARTICIPANT, Participant::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PARTICIPANT)
        }

        participant?.let {
            binding.textName.text = it.name
            binding.textPhone.text = it.phone
            binding.textEmail.text = it.email
            binding.textGender.text = it.gender
            binding.textSkillset.text = it.skillset.joinToString(", ")
            binding.textCategory.text = it.category
        }

        binding.btnInfo.setOnClickListener {
            val buttonSheet = InfoDeveloper()
            buttonSheet.show(supportFragmentManager, "InfoDeveloper")
        }
    }
}
