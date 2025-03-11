package com.example.taller1movil

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taller1movil.MIscelanius.Companion.loadJSONFromAsset
import com.example.taller1movil.databinding.ActivityPaisesBinding
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class PaisesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaisesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaisesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        JSONAdapter()

    }


    fun JSONAdapter() {
        // llenar los valores de la lista
        val json = JSONObject(loadJSONFromAsset(this, "paises.json"))
        val paisesJson = json.getJSONArray("paises")
        var arreglo = arrayOfNulls<String>(paisesJson.length())
        for (i in 0 until paisesJson.length()){
            val jsonObject = paisesJson.getJSONObject(i)

            arreglo[i] = jsonObject.getString("nombre_pais")
        }

        val adapter = ArrayAdapter(this,
            R.layout.simple_list_item_1,
            arreglo)
        binding.list.adapter = adapter


        val intent = Intent(this, DetallePaisActivity::class.java)

        //listener
        binding.list.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val jsonObject = paisesJson.getJSONObject(position)

                val capital = jsonObject.getString("capital")
                val nombre = jsonObject.getString("nombre_pais") // Obtener el nombre
                val nombreInt = jsonObject.getString("nombre_pais_int")
                val sigla = jsonObject.getString("sigla")

                intent.putExtra("capital", capital)
                intent.putExtra("nombre", nombre)
                intent.putExtra("nombreInt", nombreInt)
                intent.putExtra("sigla", sigla)

                // Iniciar la CountryDetailActivity
                startActivity(intent)
            }
        })


    }

}