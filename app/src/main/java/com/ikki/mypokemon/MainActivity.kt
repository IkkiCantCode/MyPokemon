package com.ikki.mypokemon

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var rvPokemon: RecyclerView
    private val list = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemon = findViewById(R.id.rv_pokemon)
        rvPokemon.setHasFixedSize(true)

        list.addAll(getListPokemon())
        showRecyclerList()

        val btnAboutPage = findViewById<Button>(R.id.btn_about_page)

        btnAboutPage.setOnClickListener {
            val intent = Intent(this, AboutPage::class.java)
            startActivity(intent)
        }

    }

    private fun getListPokemon(): ArrayList<Pokemon> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_kind)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val typesArray = resources.getStringArray(R.array.types)
        val heights = resources.getStringArray(R.array.pokemon_heights)
        val weights = resources.getStringArray(R.array.pokemon_weights)
        val abilities = resources.getStringArray(R.array.pokemon_abilities)
        val hiddenAbilities = resources.getStringArray(R.array.pokemon_hidden_abilities)
        val regions = resources.getStringArray(R.array.pokemon_regions)
        val generations = resources.getStringArray(R.array.pokemon_generations)
        val entry = resources.getStringArray(R.array.pokemon_entries)

        val listPokemon = ArrayList<Pokemon>()
        for (i in dataName.indices) {
            val types = typesArray[i].split(", ").map { it.trim() }
            val pokemon = Pokemon(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                type = types,
                height = heights[i],
                weight = weights[i],
                ability = abilities[i],
                hiddenAbility = hiddenAbilities[i],
                region = regions[i],
                generation = generations[i],
                entry = entry[i]
            )
            listPokemon.add(pokemon)
        }
        dataPhoto.recycle()
        return listPokemon
    }

    private fun showRecyclerList() {
        rvPokemon.layoutManager = LinearLayoutManager(this)
        val listPokemonAdapter = ListPokemonAdapter(list)
        rvPokemon.adapter = listPokemonAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvPokemon.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvPokemon.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_staggered -> {
                rvPokemon.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}