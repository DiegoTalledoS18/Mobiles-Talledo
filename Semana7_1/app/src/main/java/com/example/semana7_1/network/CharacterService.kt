package com.example.semana7_1.network
import models.Character
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    fun getCharacters():Call<List<Character>>
}