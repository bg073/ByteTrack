package com.bytetrack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bytetrack.data.model.DrinkEntry
import com.bytetrack.data.model.DrinkType
import java.util.Date

@Dao
interface DrinkEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkEntry(drinkEntry: DrinkEntry): Long
    
    @Update
    suspend fun updateDrinkEntry(drinkEntry: DrinkEntry)
    
    @Delete
    suspend fun deleteDrinkEntry(drinkEntry: DrinkEntry)
    
    @Query("SELECT * FROM drink_entries WHERE id = :id")
    fun getDrinkEntryById(id: Long): LiveData<DrinkEntry>
    
    @Query("SELECT * FROM drink_entries WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getDrinkEntriesForDateRange(startDate: Date, endDate: Date): LiveData<List<DrinkEntry>>
    
    @Query("SELECT * FROM drink_entries WHERE date BETWEEN :startDate AND :endDate AND type = :type ORDER BY date DESC")
    fun getDrinkEntriesForType(startDate: Date, endDate: Date, type: DrinkType): LiveData<List<DrinkEntry>>
    
    @Query("SELECT SUM(amount) FROM drink_entries WHERE date BETWEEN :startDate AND :endDate")
    fun getTotalLiquidForDateRange(startDate: Date, endDate: Date): LiveData<Float>
    
    @Query("SELECT SUM(amount) FROM drink_entries WHERE date BETWEEN :startDate AND :endDate AND type = :type")
    fun getTotalLiquidForType(startDate: Date, endDate: Date, type: DrinkType): LiveData<Float>
    
    @Query("SELECT SUM(calories) FROM drink_entries WHERE date BETWEEN :startDate AND :endDate")
    fun getTotalCaloriesForDateRange(startDate: Date, endDate: Date): LiveData<Int>
} 