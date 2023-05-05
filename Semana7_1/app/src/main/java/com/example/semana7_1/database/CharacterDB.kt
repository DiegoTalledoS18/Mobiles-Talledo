package com.example.semana7_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.semana7_1.database.CharacterDB

@Database(entities =[CharacterDB::class], version = 1)
abstract class CharacterDB:RoomDatabase() {
    abstract fun getTeamDAO():CharacterDAO

    companion object{

        private var INSTANCE: CharacterDB?=null

        fun getInstance(context: Context): CharacterDB{
            if(INSTANCE == null){
                INSTANCE= Room.
                databaseBuilder(context,CharacterDB::class.java,"character.db")
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE as CharacterDB
        }
    }
}