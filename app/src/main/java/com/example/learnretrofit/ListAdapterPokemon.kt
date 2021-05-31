package com.example.learnretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAdapterPokemon(val listImages : ArrayList<ResultPokemon>) :
    RecyclerView.Adapter<ListAdapterPokemon.ListPokemonHolder>() {


    inner class ListPokemonHolder(view : View) : RecyclerView.ViewHolder(view){
        val imgPokemon = view.findViewById<ImageView>(R.id.ivPokemon)
        val textPokemon = view.findViewById<TextView>(R.id.tvPokemon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPokemonHolder {
        return ListPokemonHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: ListPokemonHolder, position: Int) {
        val listImage = listImages.get(position)

        listImage.let {
            Glide.with(holder.itemView).load(getImageUrl(it.url)).into(holder.imgPokemon)
            holder.textPokemon.text = it.name

        }
    }
    fun getImageUrl(url:String): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }

    override fun getItemCount(): Int {
        return listImages.size
    }
}