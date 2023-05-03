package com.example.semana7_1.controller.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.semana7_1.R
import com.example.semana7_1.adapter.CharacterAdapter
import com.example.semana7_1.network.CharacterService
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import models.Character
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var characterRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterRecyclerView=findViewById(R.id.rvCharacters)
        loadCharacters()
    }

    private fun loadCharacters() {
        val tvName=findViewById<TextView>(R.id.tvName)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/DiegoTalledoS18/StarWars/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val characterService: CharacterService
        characterService=retrofit.create(CharacterService::class.java)
        characterService.getCharacters().enqueue(object:Callback<List<Character>>{
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                if(response.isSuccessful){
                    val characters:List<Character> =response.body()!!
                    characterRecyclerView.adapter=CharacterAdapter(characters,this@MainActivity)
                    characterRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}