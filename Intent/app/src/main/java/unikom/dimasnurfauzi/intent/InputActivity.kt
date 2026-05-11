package unikom.dimasnurfauzi.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rgGender: RadioGroup
    private lateinit var btnSave: Button

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        btnSave = findViewById(R.id.btn_save)
        rgGender = findViewById(R.id.rg_gender)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_save) {
            val selectedGenderId = rgGender.checkedRadioButtonId
            if (selectedGenderId != -1) {
                val selectedGender: RadioButton = findViewById(selectedGenderId)
                val value = selectedGender.text.toString()
                val intent = Intent()
                intent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, intent)
                finish()
            }
        }
    }
}
