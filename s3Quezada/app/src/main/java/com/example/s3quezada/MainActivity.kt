package com.example.s3quezada

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etValorA = findViewById<EditText>(R.id.etValorA)
        val etValorB = findViewById<EditText>(R.id.etValorB)
        val btn = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val spinnerOperacion = findViewById<Spinner>(R.id.spinnerOperacion)

        btn.setOnClickListener {
            val a = etValorA.text.toString().trim()
            val b = etValorB.text.toString().trim()

            if (a.isNotEmpty() && b.isNotEmpty()) {
                try {
                    val valorA = a.toDouble()
                    val valorB = b.toDouble()
                    val operacion = spinnerOperacion.selectedItem.toString()
                    val resultado = calcular(valorA, valorB, operacion)
                    tvResultado.text = "Resultado: $resultado"
                } catch (e: NumberFormatException) {
                    tvResultado.text = "Ingresa números válidos."
                } catch (e: ArithmeticException) {
                    tvResultado.text = "Error: ${e.message}"
                }
            } else {
                tvResultado.text = "Por favor, completa ambos campos."
            }
        }
    }

    private fun calcular(valorA: Double, valorB: Double, operacion: String): Double {
        return when (operacion) {
            "Suma" -> valorA + valorB
            "Resta" -> valorA - valorB
            "Multiplicación" -> valorA * valorB
            "División" -> {
                if (valorB == 0.0) throw ArithmeticException("División por cero")
                valorA / valorB
            }
            else -> 0.0
        }
    }
}

