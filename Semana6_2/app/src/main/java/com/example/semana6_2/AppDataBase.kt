package com.example.semana6_2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getDao(): ContactDao
    //patron singlenton
    companion object{
        private var INSTANCE: AppDataBase?=null

        fun getInstance(context: Context):AppDataBase{
            if(INSTANCE==null){
                INSTANCE=Room.databaseBuilder(context,AppDataBase::class.java,"contact.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDataBase
        }
    }

}