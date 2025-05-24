package com.example.s3quezadamtdburbuja

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val a = findViewById<EditText>(R.id.etValor1)
        val b = findViewById<EditText>(R.id.etValor2)
        val c = findViewById<EditText>(R.id.etValor3)
        val d = findViewById<EditText>(R.id.etValor4)
        val e = findViewById<EditText>(R.id.etValor5)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btn = findViewById<TextView>(R.id.btnCalcular)

        btn.setOnClickListener {
            try {
                val numberA = a.text.toString().trim().toDouble()
                val numberB = b.text.toString().trim().toDouble()
                val numberC = c.text.toString().trim().toDouble()
                val numberD = d.text.toString().trim().toDouble()
                val numberE = e.text.toString().trim().toDouble()

                val arregloNumerico = mutableListOf(numberA, numberB, numberC, numberD, numberE)
                val arregloOrdenado = metodoBurbuja(arregloNumerico)
                tvResultado.text = "Números ordenados: $arregloOrdenado"
            } catch (e: NumberFormatException) {
                tvResultado.text = "Por favor, ingresa solo números válidos."
            }
        }
    }

    private fun metodoBurbuja(lista: MutableList<Double>): MutableList<Double> {
        val n = lista.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (lista[j] > lista[j + 1]) {
                    val temp = lista[j]
                    lista[j] = lista[j + 1]
                    lista[j + 1] = temp
                }
            }
        }
        return lista
    }
}
