package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var07MainActivity : AppCompatActivity() {

    lateinit var e1: EditText
    lateinit var e2: EditText
    lateinit var e3: EditText
    lateinit var e4: EditText
    lateinit var button_toggle: Button

    // Variabile pentru a salva rezultatele
    private var sum: Double = 0.0
    private var product: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_main)

        e1 = findViewById(R.id.first0)
        e2 = findViewById(R.id.second0)
        e3 = findViewById(R.id.first1)
        e4 = findViewById(R.id.second1)
        button_toggle = findViewById(R.id.button_toggle)

        // Verifică dacă există date salvate
        savedInstanceState?.let {
            sum = it.getDouble("sum", 0.0)
            product = it.getDouble("product", 0.0)

            // Afișează suma și produsul dacă au fost salvate
            Toast.makeText(this, "Suma: $sum, Produsul: $product", Toast.LENGTH_LONG).show()
        }

        button_toggle.setOnClickListener {
            // Verifică dacă toate câmpurile sunt numere
            val input1 = e1.text.toString()
            val input2 = e2.text.toString()
            val input3 = e3.text.toString()
            val input4 = e4.text.toString()

            if (isNumeric(input1) && isNumeric(input2) && isNumeric(input3) && isNumeric(input4)) {
                // Dacă toate câmpurile sunt numere, lansează a doua activitate
                val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java)
                intent.putExtra("value1", input1)
                intent.putExtra("value2", input2)
                intent.putExtra("value3", input3)
                intent.putExtra("value4", input4)
                startActivityForResult(intent, 1)
            } else {
                // Dacă cel puțin un câmp nu este număr, afișează un mesaj
                Toast.makeText(this, "Toate câmpurile trebuie să conțină numere!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Funcție helper pentru a verifica dacă un text este numeric
    private fun isNumeric(str: String): Boolean {
        return str.toDoubleOrNull() != null
    }

    // Metodă pentru a salva starea activității
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("sum", sum)
        outState.putDouble("product", product)
    }

    // Metodă pentru a primi rezultatele din activitatea secundară
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val sumResult = data?.getDoubleExtra("sum", 0.0) ?: 0.0
            val productResult = data?.getDoubleExtra("product", 0.0) ?: 0.0

            // Salvează valorile sumei și produsului
            sum = sumResult
            product = productResult

            // Afișează rezultatele în Toast
            Toast.makeText(this, "Suma: $sum, Produsul: $product", Toast.LENGTH_LONG).show()
        }
    }
}
