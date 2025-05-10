package com.bytetrack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bytetrack.data.model.FoodEntry
import com.bytetrack.data.model.MealType
import java.util.Date

@Dao
interface FoodEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodEntry(foodEntry: FoodEntry): Long
    
    @Update
    suspend fun updateFoodEntry(foodEntry: FoodEntry)
    
    @Delete
    suspend fun deleteFoodEntry(foodEntry: FoodEntry)
    
    @Query("SELECT * FROM food_entries WHERE id = :id")
    fun getFoodEntryById(id: Long): LiveData<FoodEntry>
    
    @Query("SELECT * FROM food_entries WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getFoodEntriesForDateRange(startDate: Date, endDate: Date): LiveData<List<FoodEntry>>
    
    @Query("SELECT * FROM food_entries WHERE date BETWEEN :startDate AND :endDate AND mealType = :mealType ORDER BY date DESC")
    fun getFoodEntriesForMealType(startDate: Date, endDate: Date, mealType: MealType): LiveData<List<FoodEntry>>
    
    @Query("SELECT SUM(f.calories * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    fun getTotalCaloriesForDateRange(startDate: Date, endDate: Date): LiveData<Int>
    
    @Query("SELECT SUM(f.protein * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    fun getTotalProteinForDateRange(startDate: Date, endDate: Date): LiveData<Float>
    
    @Query("SELECT SUM(f.carbs * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    fun getTotalCarbsForDateRange(startDate: Date, endDate: Date): LiveData<Float>
    
    @Query("SELECT SUM(f.fat * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    fun getTotalFatForDateRange(startDate: Date, endDate: Date): LiveData<Float>
} 