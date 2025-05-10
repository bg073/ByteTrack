package com.bytetrack.data.repository

import androidx.lifecycle.LiveData
import com.bytetrack.data.dao.FoodDao
import com.bytetrack.data.model.Food

class FoodRepository(private val foodDao: FoodDao) {
    
    val allFoods: LiveData<List<Food>> = foodDao.getAllFoods()
    val favoriteFoods: LiveData<List<Food>> = foodDao.getFavoriteFoods()
    
    suspend fun insertFood(food: Food): Long {
        return foodDao.insertFood(food)
    }
    
    suspend fun updateFood(food: Food) {
        foodDao.updateFood(food)
    }
    
    suspend fun deleteFood(food: Food) {
        foodDao.deleteFood(food)
    }
    
    fun getFoodById(id: Long): LiveData<Food> {
        return foodDao.getFoodById(id)
    }
    
    fun searchFoods(query: String): LiveData<List<Food>> {
        return foodDao.searchFoods(query)
    }
    
    suspend fun getFoodByBarcode(barcode: String): Food? {
        return foodDao.getFoodByBarcode(barcode)
    }
} 