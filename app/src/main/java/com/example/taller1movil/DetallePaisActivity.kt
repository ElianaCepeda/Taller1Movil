package com.example.taller1movil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taller1movil.databinding.ActivityDetallePaisBinding

class DetallePaisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePaisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePaisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val capital = intent.getStringExtra("capital")
        val nombre = intent.getStringExtra("nombre")
        val nombreInt = intent.getStringExtra("nombreInt")
        val sigla = intent.getStringExtra("sigla")

        binding.capitalTextView.text = "Capital: $capital"
        binding.nombreTextView.text = "Nombre: $nombre"
        binding.nombreIntTextView.text = "Nombre Internacional: $nombreInt"
        binding.siglaTextView.text = "Sigla: $sigla"
    }

}