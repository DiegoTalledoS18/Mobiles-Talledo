package com.example.semana6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.semana6_1.Beans.Joke
import com.example.semana6_1.Interface.JokePlaceholder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadJoke()
        savejoke()
        loadSavejoke()
    }

    private fun loadJoke(){
        val btnJoke=findViewById<Button>(R.id.btnJoke)
        val txtJoke=findViewById<TextView>(R.id.txtJoke)

        btnJoke.setOnClickListener(){
            val retrofit = Retrofit.Builder()
                .baseUrl("https://geek-jokes.sameerkumar.website/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val jokeservice: JokePlaceholder
            jokeservice=retrofit.create(JokePlaceholder::class.java)

            val request=jokeservice.getJoke("json")

            request.enqueue(object:Callback<Joke>{
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful){
                        txtJoke.text=response.body()!!.joke
                    }
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                   Log.d("MainActivity",t.toString())
                }

            })
        }
    }
    private fun savejoke(){
        val txtJoke=findViewById<TextView>(R.id.txtJoke)
        val btnGrabar=findViewById<Button>(R.id.btnGrabar)
        val sharedPref=getSharedPreferences("myjoke", MODE_PRIVATE)
        btnGrabar.setOnClickListener(){
            val editor=sharedPref.edit()
            Toast.makeText(this,txtJoke.text.toString(),Toast.LENGTH_SHORT).show()
            editor.putString("joke",txtJoke.text.toString())
            editor.apply()
        }

    }
    private fun loadSavejoke(){
        val btnRetrieve=findViewById<Button>(R.id.btnRetrieve)
        val txtStorageJoke=findViewById<TextView>(R.id.txtStorageJoke)
        val sharedPref=getSharedPreferences("myjoke", MODE_PRIVATE)

        btnRetrieve.setOnClickListener(){
            txtStorageJoke.text=sharedPref.getString("joke","").toString()
        }

    }
}