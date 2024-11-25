package com.example.ejercicioindividual15

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioindividual15.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val repository = PersonRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.progressBar.visibility = View.VISIBLE


        CoroutineScope(Dispatchers.IO).launch {
            val personList = repository.getPersonList()

            withContext(Dispatchers.Main) {
                binding.recyclerView.adapter = PersonAdapter(personList)
                binding.progressBar.visibility = View.GONE
            }
        }


        binding.buttonReload.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                val personList = repository.getPersonList()

                withContext(Dispatchers.Main) {
                    binding.recyclerView.adapter = PersonAdapter(personList)
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}