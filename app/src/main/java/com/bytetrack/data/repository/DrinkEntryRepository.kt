package com.bytetrack.data.repository

import androidx.lifecycle.LiveData
import com.bytetrack.data.dao.DrinkEntryDao
import com.bytetrack.data.model.DrinkEntry
import com.bytetrack.data.model.DrinkType
import com.bytetrack.utils.DateUtils
import java.util.Date

class DrinkEntryRepository(private val drinkEntryDao: DrinkEntryDao) {
    
    fun getDrinkEntriesForToday(): LiveData<List<DrinkEntry>> {
        val today = DateUtils.getTodayStart()
        val tomorrow = DateUtils.getTomorrowStart()
        return drinkEntryDao.getDrinkEntriesForDateRange(today, tomorrow)
    }
    
    fun getDrinkEntriesForDate(date: Date): LiveData<List<DrinkEntry>> {
        val startOfDay = DateUtils.getStartOfDay(date)
        val endOfDay = DateUtils.getEndOfDay(date)
        return drinkEntryDao.getDrinkEntriesForDateRange(startOfDay, endOfDay)
    }
    
    fun getDrinkEntriesForDateAndType(date: Date, type: DrinkType): LiveData<List<DrinkEntry>> {
        val startOfDay = DateUtils.getStartOfDay(date)
        val endOfDay = DateUtils.getEndOfDay(date)
        return drinkEntryDao.getDrinkEntriesForType(startOfDay, endOfDay, type)
    }
    
    fun getTotalLiquidForToday(): LiveData<Float> {
        val today = DateUtils.getTodayStart()
        val tomorrow = DateUtils.getTomorrowStart()
        return drinkEntryDao.getTotalLiquidForDateRange(today, tomorrow)
    }
    
    fun getTotalWaterForToday(): LiveData<Float> {
        val today = DateUtils.getTodayStart()
        val tomorrow = DateUtils.getTomorrowStart()
        return drinkEntryDao.getTotalLiquidForType(today, tomorrow, DrinkType.WATER)
    }
    
    fun getTotalCaloriesFromDrinksForToday(): LiveData<Int> {
        val today = DateUtils.getTodayStart()
        val tomorrow = DateUtils.getTomorrowStart()
        return drinkEntryDao.getTotalCaloriesForDateRange(today, tomorrow)
    }
    
    suspend fun insertDrinkEntry(drinkEntry: DrinkEntry): Long {
        return drinkEntryDao.insertDrinkEntry(drinkEntry)
    }
    
    suspend fun updateDrinkEntry(drinkEntry: DrinkEntry) {
        drinkEntryDao.updateDrinkEntry(drinkEntry)
    }
    
    suspend fun deleteDrinkEntry(drinkEntry: DrinkEntry) {
        drinkEntryDao.deleteDrinkEntry(drinkEntry)
    }
    
    fun getDrinkEntryById(id: Long): LiveData<DrinkEntry> {
        return drinkEntryDao.getDrinkEntryById(id)
    }
} 