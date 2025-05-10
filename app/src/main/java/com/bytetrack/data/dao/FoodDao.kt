package com.bytetrack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bytetrack.data.model.Food

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food): Long
    
    @Update
    suspend fun updateFood(food: Food)
    
    @Delete
    suspend fun deleteFood(food: Food)
    
    @Query("SELECT * FROM foods WHERE id = :id")
    fun getFoodById(id: Long): LiveData<Food>
    
    @Query("SELECT * FROM foods ORDER BY name ASC")
    fun getAllFoods(): LiveData<List<Food>>
    
    @Query("SELECT * FROM foods WHERE name LIKE '%' || :searchQuery || '%'")
    fun searchFoods(searchQuery: String): LiveData<List<Food>>
    
    @Query("SELECT * FROM foods WHERE barcode = :barcode LIMIT 1")
    suspend fun getFoodByBarcode(barcode: String): Food?
    
    @Query("SELECT * FROM foods WHERE isFavorite = 1 ORDER BY name ASC")
    fun getFavoriteFoods(): LiveData<List<Food>>
} 