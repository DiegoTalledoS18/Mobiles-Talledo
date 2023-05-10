package com.example.semana7_1.controller.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.semana7_1.R
import com.example.semana7_1.adapter.CharacterAdapter
import com.example.semana7_1.controller.activity.CharacterDetail
import com.example.semana7_1.network.CharacterService
import models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterList : Fragment(),CharacterAdapter.OnItemClickListener {
    lateinit var characterRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view :View =inflater.inflate(R.layout.fragment_character_list, container, false)

        characterRecyclerView=view.findViewById(R.id.rvCharacters)
        loadCharacters(view)

        return view
    }
    private fun loadCharacters(view: View) {
        val tvName=view.findViewById<TextView>(R.id.tvName)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/DiegoTalledoS18/StarWars/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val characterService: CharacterService
        characterService=retrofit.create(CharacterService::class.java)
        characterService.getCharacters().enqueue(object: Callback<List<Character>> {
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                if(response.isSuccessful){
                    val characters:List<Character> =response.body()!!
                    characterRecyclerView.adapter= CharacterAdapter(characters,requireContext(),this@CharacterList)
                    characterRecyclerView.layoutManager= LinearLayoutManager(context)
                }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onItemClicked(character: Character) {
        val intent = Intent(context, CharacterDetail::class.java)
        intent.putExtra("character", character)
        startActivity(intent)

    }


}