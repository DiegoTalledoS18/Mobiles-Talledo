package com.example.semana6_1.Interface

import com.example.semana6_1.Beans.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JokePlaceholder {
    @GET("api")
    fun getJoke(@Query("format")format: String): Call<Joke>

}