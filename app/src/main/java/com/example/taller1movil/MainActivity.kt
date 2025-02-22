package com.example.taller1movil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1movil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Empieza el codigo

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)// Asociacion a pantalla




    }
}