package com.empresa.calculadera

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.empresa.calculadera.databinding.PlanetsLayoutBinding

class ActivityPlanets : AppCompatActivity(), OnPlanetClick {
    private val binding by lazy { PlanetsLayoutBinding.inflate(layoutInflater) }
    private val viewModel: PlanetsViewModel by viewModels()
    private val adapter by lazy { PlanetsListAdapter(emptyList(), this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        bindViews()

    }

    private fun bindViews() {
        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this)
        }

        binding.ibAdd.setOnClickListener {
            viewModel.add(binding.etText.text.toString())
        }

        viewModel.list.observe(this) {
            adapter.updateList(it)
        }
    }

    override fun onSelect(planet: String) {
        Toast.makeText(this, planet, Toast.LENGTH_SHORT).show()
    }
}