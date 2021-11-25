package urraan.internship.chapter2_loginpage.entity

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BikeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBikeData(bike: Bike)

    @Query("SELECT * FROM Bike order by model_No ASC" )
    fun readBikeData(): LiveData<List<Bike>>

    @Update
    suspend fun updateBikeData(bike: Bike)

    @Delete
    suspend fun deleteBikeData(bike: Bike)

    @Query("Select * from Bike where model_No Like :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<Bike>>
}
