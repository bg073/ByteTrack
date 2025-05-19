package com.bytetrack.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bytetrack.data.AppDatabase
import com.bytetrack.data.model.UserProfile
import com.bytetrack.data.repository.DrinkEntryRepository
import com.bytetrack.data.repository.FoodEntryRepository
import com.bytetrack.data.repository.UserProfileRepository
import com.bytetrack.utils.DateUtils
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

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
    
    // Add weekly data tracking for progress visualization
    data class DailyProgress(val date: Date, val calories: Int, val water: Float)
    
    private val _weeklyProgress = MutableLiveData<List<DailyProgress>>()
    val weeklyProgress: LiveData<List<DailyProgress>> = _weeklyProgress
    
    // Track goal completion state to trigger animations
    private val _goalCompleted = MutableLiveData<Boolean>(false)
    val goalCompleted: LiveData<Boolean> = _goalCompleted
    
    // Common food/drink items for quick add
    data class QuickAddItem(val name: String, val calories: Int, val type: String)
    
    private val _quickAddItems = MutableLiveData<List<QuickAddItem>>()
    val quickAddItems: LiveData<List<QuickAddItem>> = _quickAddItems
    
    init {
        _totalCalories.addSource(foodEntryRepository.getTotalCaloriesForToday()) { foodCalories ->
            val drinkCalories = drinkEntryRepository.getTotalCaloriesFromDrinksForToday().value ?: 0
            _totalCalories.value = (foodCalories ?: 0) + drinkCalories
            
            // Check if goal is completed
            checkGoalCompletion()
        }
        
        _totalCalories.addSource(drinkEntryRepository.getTotalCaloriesFromDrinksForToday()) { drinkCalories ->
            val foodCalories = foodEntryRepository.getTotalCaloriesForToday().value ?: 0
            _totalCalories.value = foodCalories + (drinkCalories ?: 0)
            
            // Check if goal is completed
            checkGoalCompletion()
        }
        
        // Initialize quick add items (in a real app, these would come from user history)
        loadQuickAddItems()
        
        // Load weekly progress data
        loadWeeklyProgressData()
    }
    
    fun refreshData() {
        // No need to manually refresh with Room LiveData
        loadWeeklyProgressData()
        checkGoalCompletion()
    }
    
    private fun checkGoalCompletion() {
        // Check if user has reached their calorie goal
        val currentCalories = _totalCalories.value ?: 0
        val calorieGoal = userProfile.value?.dailyCalorieGoal ?: 2000
        
        // Goal is considered complete when they reach at least 90% of their target
        val newGoalCompletedState = currentCalories >= (calorieGoal * 0.9)
        
        // Only trigger animation if state has changed from false to true
        if (newGoalCompletedState && _goalCompleted.value == false) {
            _goalCompleted.value = true
        } else {
            _goalCompleted.value = newGoalCompletedState
        }
    }
    
    // Function to update user's calorie goal
    fun updateCalorieGoal(newGoal: Int) {
        viewModelScope.launch {
            val currentProfile = userProfile.value ?: UserProfile(dailyCalorieGoal = 2000)
            val updatedProfile = currentProfile.copy(dailyCalorieGoal = newGoal)
            userProfileRepository.updateUserProfile(updatedProfile)
        }
    }
    
    private fun loadWeeklyProgressData() {
        // In a real app, this would query the database for the past 7 days
        // For now, we'll create sample data
        val calendar = Calendar.getInstance()
        val today = calendar.time
        val weeklyData = mutableListOf<DailyProgress>()
        
        // Generate the past 7 days of data
        for (i in 6 downTo 0) {
            calendar.time = today
            calendar.add(Calendar.DAY_OF_YEAR, -i)
            val date = calendar.time
            
            // Generate some sample data with realistic pattern
            // In a real app, this would come from repositories
            val baseCalories = 1800
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            
            // More calories on weekends, less on weekdays
            val calorieMultiplier = when (dayOfWeek) {
                Calendar.SATURDAY, Calendar.SUNDAY -> 1.2f
                else -> 0.9f + (Math.random() * 0.3f).toFloat()
            }
            
            val calories = (baseCalories * calorieMultiplier).toInt()
            val water = 1500f + (Math.random() * 1000).toFloat()
            
            weeklyData.add(DailyProgress(date, calories, water))
        }
        
        _weeklyProgress.value = weeklyData
    }
    
    private fun loadQuickAddItems() {
        // In a real app, these would be the user's most frequent items
        // For now, we'll use sample data
        _quickAddItems.value = listOf(
            QuickAddItem("Coffee", 5, "drink"),
            QuickAddItem("Banana", 105, "food"),
            QuickAddItem("Protein Bar", 200, "food"),
            QuickAddItem("Water (500ml)", 0, "drink"),
            QuickAddItem("Yogurt", 150, "food"),
            QuickAddItem("Apple", 95, "food")
        )
    }
} 