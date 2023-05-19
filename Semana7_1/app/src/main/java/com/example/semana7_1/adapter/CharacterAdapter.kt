package com.example.semana7_1.adapter
import models.Character
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.semana7_1.R
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class CharacterAdapter(val characters: List<Character>,val context: Context, val itemClickListener: OnItemClickListener): Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val ivProfile=view.findViewById<ImageView>(R.id.ivProfile)
        val tvName=view.findViewById<TextView>(R.id.tvName)
        val cvCharacter=view.findViewById<CardView>(R.id.cvCharacter)

    }
    interface OnItemClickListener{
        fun onItemClicked(character: models.Character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.prototype_character,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        val character=characters[position]
        holder.tvName.text=character.name

        holder.cvCharacter.setOnClickListener(){
            itemClickListener.onItemClicked(character)
        }

        //cargando la img
        val picBuilder=Picasso.Builder(context)
        picBuilder.downloader((OkHttp3Downloader(context)))
        picBuilder.build().load(character.img).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(holder.ivProfile)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}