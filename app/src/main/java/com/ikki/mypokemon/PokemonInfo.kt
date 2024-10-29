package com.ikki.mypokemon

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PokemonInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_info)

        val pokemon = intent.getParcelableExtra<Pokemon>("EXTRA_POKEMON")

        val tvName: TextView = findViewById(R.id.tv_pokemon_name)
        val tvDescription: TextView = findViewById(R.id.tv_pokemon_description)
        val imgPhoto : ImageView = findViewById(R.id.img_pokemon_photo)
        val tvTypes: TextView = findViewById(R.id.tv_type_value)
        val tvHeight: TextView = findViewById(R.id.tv_height_value)
        val tvWeight: TextView = findViewById(R.id.tv_weight_value)
        val tvAbility: TextView = findViewById(R.id.tv_ability_value)
        val tvHiddenAbility: TextView = findViewById(R.id.tv_hidden_ability_value)
        val tvRegion: TextView = findViewById(R.id.tv_region_value)
        val tvGeneration: TextView = findViewById(R.id.tv_generation_value)
        val tvEntry: TextView = findViewById((R.id.tv_entry_value))

        pokemon?.let {
            tvName.text = it.name
            tvDescription.text = it.kind
            imgPhoto.setImageResource(it.photo)
            tvTypes.text = it.type.joinToString(", ") // Display types
            tvHeight.text = it.height
            tvWeight.text = it.weight
            tvAbility.text = it.ability
            tvHiddenAbility.text = it.hiddenAbility
            tvRegion.text = it.region
            tvGeneration.text = it.generation
            tvEntry.text = it.entry
        }
    }
}