package com.empresa.calculadera

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.empresa.calculadera.databinding.PlanetsLayoutBinding

class ActivityPlanets : AppCompatActivity() {
    private lateinit var binding: PlanetsLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PlanetsLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView

        recyclerView.adapter = PlanetsListAdapter(planets) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}