package com.ikki.mypokemon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPokemonAdapter(private val listPokemon: ArrayList<Pokemon>) : RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_pokemon, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pokemon = listPokemon[position]
        holder.imgPhoto.setImageResource(pokemon.photo)
        holder.tvName.text = pokemon.name
        holder.tvDescription.text = pokemon.kind

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, PokemonInfo::class.java).apply {
                putExtra("EXTRA_POKEMON", pokemon)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listPokemon.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}