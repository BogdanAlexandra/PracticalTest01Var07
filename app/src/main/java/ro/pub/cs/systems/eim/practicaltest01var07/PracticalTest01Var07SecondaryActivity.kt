package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_secondary)

        val textView1: TextView = findViewById(R.id.first0)
        val textView2: TextView = findViewById(R.id.second0)
        val textView3: TextView = findViewById(R.id.first1)
        val textView4: TextView = findViewById(R.id.second1)
        val buttonSum: Button = findViewById(R.id.button_sum)
        val buttonProduct: Button = findViewById(R.id.button_product)

        // Preia valorile trimise prin Intent
        val value1 = intent.getStringExtra("value1")?.toDoubleOrNull() ?: 0.0
        val value2 = intent.getStringExtra("value2")?.toDoubleOrNull() ?: 0.0
        val value3 = intent.getStringExtra("value3")?.toDoubleOrNull() ?: 0.0
        val value4 = intent.getStringExtra("value4")?.toDoubleOrNull() ?: 0.0

        // Afișează valorile în TextView-uri
        textView1.text = value1.toString()
        textView2.text = value2.toString()
        textView3.text = value3.toString()
        textView4.text = value4.toString()

        // Funcționalitate pentru butonul Sum
        buttonSum.setOnClickListener {
            val sum = value1 + value2 + value3 + value4
            Toast.makeText(this, "Suma: $sum", Toast.LENGTH_SHORT).show()

            // Trimite rezultatul înapoi la activitatea principală
            val resultIntent = Intent()
            resultIntent.putExtra("sum", sum)
            setResult(RESULT_OK, resultIntent)
            finish() // Închide activitatea secundară
        }

        // Funcționalitate pentru butonul Product
        buttonProduct.setOnClickListener {
            val product = value1 * value2 * value3 * value4
            Toast.makeText(this, "Produsul: $product", Toast.LENGTH_SHORT).show()

            // Trimite rezultatul înapoi la activitatea principală
            val resultIntent = Intent()
            resultIntent.putExtra("product", product)
            setResult(RESULT_OK, resultIntent)
            finish() // Închide activitatea secundară
        }
    }
}
