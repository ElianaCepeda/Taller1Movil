package com.example.taller1movil

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1movil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)//

        // Configurar listeners
        configurarListeners()
        irAPaises()

        // Asociacion a pantalla
        binding.btnTriqui.setOnClickListener {
            val intent = Intent(this, TriquiActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configurarListeners() {
        binding.btnRandomGreet.setOnClickListener {
            val idiomaSeleccionado = binding.spinnerLanguages.selectedItem.toString()
            mostrarSaludoEnNuevaPantalla(idiomaSeleccionado)
        }
    }

    private fun mostrarSaludoEnNuevaPantalla(idioma: String) {
        val saludo = obtenerSaludo(idioma)
        val intent = Intent(this, SaludoActivity::class.java)
        intent.putExtra("saludo", saludo)
        startActivity(intent)
    }

    private fun obtenerSaludo(idioma: String): String {
        return when (idioma) {
            "Español" -> "¡Hola!"
            "Inglés" -> "Hello!"
            "Francés" -> "Bonjour!"
            "Aleman" -> "Hallo!"
            "Italiano" -> "Ciao!"
            else -> "Saludo no disponible"
        }
    }

    private fun irAPaises() {
        binding.btnCountries.setOnClickListener {
            val intent = Intent(this, PaisesActivity::class.java)
            startActivity(intent)
        }
    }

}