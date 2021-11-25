package urraan.internship.chapter2_loginpage.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Bike::class], version = 1, exportSchema = false)
abstract class BikeDatabase: RoomDatabase() {
    abstract val bikeDao: BikeDao

    companion object{
        @Volatile
        private var INSTANCE: BikeDatabase? = null

        fun getDatabase(context: Context): BikeDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    BikeDatabase::class.java,
                    "Bike_DataBase"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}