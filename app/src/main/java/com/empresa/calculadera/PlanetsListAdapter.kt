package com.empresa.calculadera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.empresa.calculadera.databinding.PlanetsListBinding

class PlanetsListAdapter(
    private var planets: List<String>,
    private val listner: OnPlanetClick
) :

    RecyclerView.Adapter<PlanetsListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PlanetsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: String) {
            binding.tvPlanetsName.text = planet
            binding.tvPlanetsName.setOnClickListener {
                listner.onSelect(planet)
            }
        }
    }

    //Criar a visualização dos itens da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PlanetsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //Atribuir informação a cada um dos itens criados acima
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(planets[position])
    }

    override fun getItemCount() = planets.size

    fun updateList(planets: List<String>) {
        this.planets = planets
        this.notifyDataSetChanged()
    }

}

interface OnPlanetClick {
    fun onSelect(planet: String)
}