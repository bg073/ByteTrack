package com.bytetrack.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.bytetrack.data.AppDatabase
import com.bytetrack.data.model.UserProfile
import com.bytetrack.data.repository.DrinkEntryRepository
import com.bytetrack.data.repository.FoodEntryRepository
import com.bytetrack.data.repository.UserProfileRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = AppDatabase.getDatabase(application)
    
    private val foodEntryRepository = FoodEntryRepository(database.foodEntryDao())
    private val drinkEntryRepository = DrinkEntryRepository(database.drinkEntryDao())
    private val userProfileRepository = UserProfileRepository(database.userProfileDao())
    
    val todayCalories: LiveData<Int> = foodEntryRepository.getTotalCaloriesForToday()
    val waterIntake: LiveData<Float> = drinkEntryRepository.getTotalWaterForToday()
    val userProfile: LiveData<UserProfile> = userProfileRepository.userProfile
    
    private val _totalCalories = MediatorLiveData<Int>()
    val totalCalories: LiveData<Int> = _totalCalories
    
    init {
        _totalCalories.addSource(foodEntryRepository.getTotalCaloriesForToday()) { foodCalories ->
            val drinkCalories = drinkEntryRepository.getTotalCaloriesFromDrinksForToday().value ?: 0
            _totalCalories.value = (foodCalories ?: 0) + drinkCalories
        }
        
        _totalCalories.addSource(drinkEntryRepository.getTotalCaloriesFromDrinksForToday()) { drinkCalories ->
            val foodCalories = foodEntryRepository.getTotalCaloriesForToday().value ?: 0
            _totalCalories.value = foodCalories + (drinkCalories ?: 0)
        }
    }
    
    fun refreshData() {
        // No need to manually refresh with Room LiveData
    }
    
    fun updateUserProfile(userProfile: UserProfile) {
        viewModelScope.launch {
            userProfileRepository.updateUserProfile(userProfile)
        }
    }
} 