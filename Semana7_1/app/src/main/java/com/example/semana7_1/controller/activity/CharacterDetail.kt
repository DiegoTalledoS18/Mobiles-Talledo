package com.example.semana7_1.controller.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.semana7_1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class CharacterDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        initFields()
        addFavorite()
    }

    private fun initFields(){
        val imgCharacterDetail = findViewById<ImageView>(R.id.imgCharacterDetail)
        val tvNameDetails = findViewById<TextView>(R.id.tvNameDetails)
        val tvBirthDayDetail = findViewById<TextView>(R.id.tvBirthDayDetail)
        val tvGenderDetail = findViewById<TextView>(R.id.tvGenderDetail)

        val characterObject: models.Character = intent.getSerializableExtra("character") as models.Character

        val picBuilder= Picasso.Builder(this)
        picBuilder.downloader((OkHttp3Downloader(this)))
        picBuilder.build().load(characterObject.img).into(imgCharacterDetail)
        tvNameDetails.setText(characterObject.name)
        tvBirthDayDetail.setText(characterObject.birth_year)
        tvGenderDetail.setText(characterObject.gender)

    }
    private fun addFavorite(){
        val fabSave = findViewById<FloatingActionButton>(R.id.floatingFavActionButton)
        fabSave.setOnClickListener(){
            finish()
        }
    }
}