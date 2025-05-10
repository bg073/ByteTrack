package com.bytetrack.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bytetrack.data.AppDatabase
import com.bytetrack.data.model.Food
import com.bytetrack.data.model.FoodEntry
import com.bytetrack.data.model.MealType
import com.bytetrack.data.repository.FoodEntryRepository
import com.bytetrack.data.repository.FoodRepository
import com.bytetrack.data.repository.OpenFoodFactsRepository
import kotlinx.coroutines.launch
import java.util.Date

class LogFoodViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = AppDatabase.getDatabase(application)
    
    private val foodRepository = FoodRepository(database.foodDao())
    private val foodEntryRepository = FoodEntryRepository(database.foodEntryDao())
    private val openFoodFactsRepository = OpenFoodFactsRepository()
    
    private val _scannedFood = MutableLiveData<Food?>()
    val scannedFood: LiveData<Food?> = _scannedFood
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage
    
    fun setScannedFood(food: Food) {
        _scannedFood.value = food
    }
    
    fun searchFoodByBarcode(barcode: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            try {
                // First check local database
                var food = foodRepository.getFoodByBarcode(barcode)
                
                if (food == null) {
                    // If not found locally, try OpenFoodFacts API
                    val result = openFoodFactsRepository.getProductByBarcode(barcode)
                    
                    result.onSuccess { apiFood ->
                        if (apiFood != null) {
                            food = apiFood
                        } else {
                            _errorMessage.value = "Product not found"
                        }
                    }.onFailure {
                        _errorMessage.value = "Error: ${it.message}"
                    }
                }
                
                _scannedFood.value = food
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun logFoodEntry(food: Food, mealType: MealType, servings: Float, notes: String? = null) {
        viewModelScope.launch {
            // First ensure the food is saved to the database
            val foodId = if (food.id == 0L) {
                foodRepository.insertFood(food)
            } else {
                food.id
            }
            
            // Then create the food entry
            val foodEntry = FoodEntry(
                foodId = foodId,
                date = Date(),
                mealType = mealType,
                servings = servings,
                notes = notes
            )
            
            foodEntryRepository.insertFoodEntry(foodEntry)
            
            // Clear scanned food
            _scannedFood.value = null
        }
    }
    
    fun clearScannedFood() {
        _scannedFood.value = null
        _errorMessage.value = null
    }
} 