package com.bytetrack.data.repository

import androidx.lifecycle.LiveData
import com.bytetrack.data.dao.FoodEntryDao
import com.bytetrack.data.model.FoodEntry
import com.bytetrack.data.model.MealType
import com.bytetrack.utils.DateUtils
import java.util.Date

class FoodEntryRepository(private val foodEntryDao: FoodEntryDao) {
    
    fun getFoodEntriesForToday(): LiveData<List<FoodEntry>> {
        val today = DateUtils.getTodayStart()
        val tomorrow = DateUtils.getTomorrowStart()
        return foodEntryDao.getFoodEntriesForDateRange(today, tomorrow)
    }
    
    fun getFoodEntriesForDate(date: Date): LiveData<List<FoodEntry>> {
        val startOfDay = DateUtils.getStartOfDay(date)
        val endOfDay = DateUtils.getEndOfDay(date)
        return foodEntryDao.getFoodEntriesForDateRange(startOfDay, endOfDay)
    }
    
    fun getFoodEntriesForDateRange(startDate: Date, endDate: Date): LiveData<List<FoodEntry>> {
        return foodEntryDao.getFoodEntriesForDateRange(startDate, endDate)
    }
    
    fun getFoodEntriesForDateAndMealType(date: Date, mealType: MealType): LiveData<List<FoodEntry>> {
        val startOfDay = DateUtils.getStartOfDay(date)
        val endOfDay = DateUtils.getEndOfDay(date)
        return foodEntryDao.getFoodEntriesForMealType(startOfDay, endOfDay, mealType)
    }
    
    fun getTotalCaloriesForToday(): LiveData<Int> {
        val today = DateUtils.getTodayStart()
        val tomorrow = DateUtils.getTomorrowStart()
        return foodEntryDao.getTotalCaloriesForDateRange(today, tomorrow)
    }
    
    fun getTotalNutrientsForToday(): Map<String, LiveData<*>> {
        val today = DateUtils.getTodayStart()
        val tomorrow = DateUtils.getTomorrowStart()
        
        return mapOf(
            "calories" to foodEntryDao.getTotalCaloriesForDateRange(today, tomorrow),
            "protein" to foodEntryDao.getTotalProteinForDateRange(today, tomorrow),
            "carbs" to foodEntryDao.getTotalCarbsForDateRange(today, tomorrow),
            "fat" to foodEntryDao.getTotalFatForDateRange(today, tomorrow)
        )
    }
    
    suspend fun insertFoodEntry(foodEntry: FoodEntry): Long {
        return foodEntryDao.insertFoodEntry(foodEntry)
    }
    
    suspend fun updateFoodEntry(foodEntry: FoodEntry) {
        foodEntryDao.updateFoodEntry(foodEntry)
    }
    
    suspend fun deleteFoodEntry(foodEntry: FoodEntry) {
        foodEntryDao.deleteFoodEntry(foodEntry)
    }
    
    fun getFoodEntryById(id: Long): LiveData<FoodEntry> {
        return foodEntryDao.getFoodEntryById(id)
    }
} 