package com.example.taller1movil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1movil.databinding.ActivityTriquiBinding

class ActivityTriqui : AppCompatActivity() {
    private lateinit var binding: ActivityTriquiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTriquiBinding.inflate(layoutInflater)
        setContentView(binding.root)  // Enlazar con el layout de la actividad
    }
}
