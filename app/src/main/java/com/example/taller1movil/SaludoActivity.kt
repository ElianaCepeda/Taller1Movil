package com.example.taller1movil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taller1movil.databinding.ActivitySaludoBinding
import com.example.taller1movil.databinding.ActivityTriquiBinding

class SaludoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySaludoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val saludo = intent.getStringExtra("saludo")
        binding.saludoTextView.text = saludo
    }


}