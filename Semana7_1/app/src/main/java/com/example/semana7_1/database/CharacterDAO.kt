package com.example.semana7_1.database

import androidx.room.*
import models.Character

@Dao
interface CharacterDAO {

    @Insert
    fun insertCharacter(vararg character: Character)

    @Query("SELECT * FROM characters")
    fun getAllCharacters():List<Character>

    @Delete
    fun deleteCharacters(vararg character: Character)

    @Update
    fun updateCharacter(vararg character: Character)
}