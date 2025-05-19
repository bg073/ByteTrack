package com.bytetrack.ui.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bytetrack.data.AppDatabase
import com.bytetrack.data.model.Food
import com.bytetrack.data.model.FoodEntry
import com.bytetrack.data.model.MealType
import com.bytetrack.data.repository.FoodEntryRepository
import com.bytetrack.utils.DateUtils
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class StatsViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = AppDatabase.getDatabase(application)
    private val foodEntryRepository = FoodEntryRepository(database.foodEntryDao())
    
    // SharedPreferences for storing analytics data
    private val preferences: SharedPreferences = application.getSharedPreferences(
        "bytetrack_stats_preferences", Context.MODE_PRIVATE
    )
    
    // Filter states
    private val _selectedTimeFrame = MutableLiveData<TimeFrame>(TimeFrame.WEEK)
    val selectedTimeFrame: LiveData<TimeFrame> = _selectedTimeFrame
    
    private val _selectedMealType = MutableLiveData<ViewMealType?>(null)
    val selectedMealType: LiveData<ViewMealType?> = _selectedMealType
    
    private val _selectedFoodCategory = MutableLiveData<FoodCategory?>(null)
    val selectedFoodCategory: LiveData<FoodCategory?> = _selectedFoodCategory
    
    private val _selectedDateRange = MutableLiveData<Pair<Date, Date>>(
        Pair(DateUtils.getStartOfWeek(), DateUtils.getEndOfWeek())
    )
    val selectedDateRange: LiveData<Pair<Date, Date>> = _selectedDateRange
    
    // Placeholder for stats data classes (these would be more complex in a real app)
    data class NutritionData(
        val calories: Int,
        val protein: Float,
        val carbs: Float,
        val fat: Float
    )
    
    data class MealData(
        val date: Date,
        val mealType: ViewMealType,
        val nutrition: NutritionData,
        val foodCategory: FoodCategory? = null
    )
    
    data class DailyStats(
        val date: Date, 
        val totalCalories: Int,
        val totalProtein: Float, 
        val totalCarbs: Float, 
        val totalFat: Float,
        val mealBreakdown: Map<ViewMealType, NutritionData>,
        val categoryBreakdown: Map<FoodCategory, NutritionData>
    )
    
    data class WeeklyStats(
        val startDate: Date, 
        val endDate: Date, 
        val dailyCalories: Map<Date, Int>,
        val averageCalories: Int,
        val averageProtein: Float,
        val averageCarbs: Float,
        val averageFat: Float,
        val mealTypePercentages: Map<ViewMealType, Float>,
        val foodCategoryPercentages: Map<FoodCategory, Float>
    )
    
    data class MonthlyStats(
        val startDate: Date, 
        val endDate: Date, 
        val dailyCalories: Map<Date, Int>,
        val weeklyAverages: List<Pair<Date, Int>>,
        val monthlyAvgCalories: Int,
        val monthlyAvgProtein: Float,
        val monthlyAvgCarbs: Float,
        val monthlyAvgFat: Float,
        val topCategories: List<Pair<FoodCategory, Int>>
    )
    
    data class NutritionInsight(
        val type: InsightType,
        val title: String,
        val description: String,
        val value: Float,
        val recommendation: String? = null
    )
    
    private val _dailyStats = MutableLiveData<DailyStats>()
    val dailyStats: LiveData<DailyStats> = _dailyStats
    
    private val _weeklyStats = MutableLiveData<WeeklyStats>()
    val weeklyStats: LiveData<WeeklyStats> = _weeklyStats
    
    private val _monthlyStats = MutableLiveData<MonthlyStats>()
    val monthlyStats: LiveData<MonthlyStats> = _monthlyStats
    
    private val _filteredMealData = MutableLiveData<List<MealData>>()
    val filteredMealData: LiveData<List<MealData>> = _filteredMealData
    
    private val _nutritionInsights = MutableLiveData<List<NutritionInsight>>()
    val nutritionInsights: LiveData<List<NutritionInsight>> = _nutritionInsights
    
    init {
        loadStats()
        generateInsights()
    }
    
    fun setTimeFrame(timeFrame: TimeFrame) {
        _selectedTimeFrame.value = timeFrame
        updateDateRange(timeFrame)
        applyFilters()
    }
    
    fun setMealType(mealType: ViewMealType?) {
        _selectedMealType.value = mealType
        applyFilters()
    }
    
    fun setFoodCategory(category: FoodCategory?) {
        _selectedFoodCategory.value = category
        applyFilters()
    }
    
    fun setCustomDateRange(startDate: Date, endDate: Date) {
        _selectedDateRange.value = Pair(startDate, endDate)
        _selectedTimeFrame.value = TimeFrame.CUSTOM
        applyFilters()
    }
    
    private fun updateDateRange(timeFrame: TimeFrame) {
        val start: Date
        val end: Date
        
        when (timeFrame) {
            TimeFrame.DAY -> {
                start = DateUtils.getStartOfDay(Date())
                end = DateUtils.getEndOfDay(Date())
            }
            TimeFrame.WEEK -> {
                start = DateUtils.getStartOfWeek()
                end = DateUtils.getEndOfWeek()
            }
            TimeFrame.MONTH -> {
                start = DateUtils.getStartOfMonth()
                end = DateUtils.getEndOfMonth()
            }
            TimeFrame.YEAR -> {
                start = getStartOfYear()
                end = getEndOfYear()
            }
            TimeFrame.CUSTOM -> {
                val customRange = _selectedDateRange.value
                start = customRange?.first ?: DateUtils.getStartOfWeek()
                end = customRange?.second ?: DateUtils.getEndOfWeek()
            }
        }
        
        _selectedDateRange.value = Pair(start, end)
    }
    
    // Helper functions for year stats
    private fun getStartOfYear(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_YEAR, 1)
        return DateUtils.getStartOfDay(calendar.time)
    }
    
    private fun getEndOfYear(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, 11) // December (0-based)
        calendar.set(Calendar.DAY_OF_MONTH, 31) // Last day of December
        return DateUtils.getEndOfDay(calendar.time)
    }
    
    private fun applyFilters() {
        loadStats()
    }
    
    private fun loadStats() {
        viewModelScope.launch {
            loadDailyStats()
            loadWeeklyStats()
            loadMonthlyStats()
            loadFilteredMealData()
        }
    }
    
    private fun loadDailyStats() {
        // First check if we have cached data in SharedPreferences
        val todayKey = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())
        val cachedData = preferences.getString("daily_stats_$todayKey", null)
        
        if (cachedData != null) {
            try {
                val json = JSONObject(cachedData)
                val today = Date()
                
                val totalCalories = json.getInt("totalCalories")
                val totalProtein = json.getDouble("totalProtein").toFloat()
                val totalCarbs = json.getDouble("totalCarbs").toFloat()
                val totalFat = json.getDouble("totalFat").toFloat()
                
                // Parse meal breakdown
                val mealBreakdownMap = mutableMapOf<ViewMealType, NutritionData>()
                val mealJson = json.getJSONObject("mealBreakdown")
                ViewMealType.values().forEach { mealType ->
                    if (mealJson.has(mealType.name)) {
                        val mealData = mealJson.getJSONObject(mealType.name)
                        mealBreakdownMap[mealType] = NutritionData(
                            calories = mealData.getInt("calories"),
                            protein = mealData.getDouble("protein").toFloat(),
                            carbs = mealData.getDouble("carbs").toFloat(),
                            fat = mealData.getDouble("fat").toFloat()
                        )
                    }
                }
                
                // Parse category breakdown
                val categoryBreakdownMap = mutableMapOf<FoodCategory, NutritionData>()
                val categoryJson = json.getJSONObject("categoryBreakdown")
                FoodCategory.values().forEach { category ->
                    if (categoryJson.has(category.name)) {
                        val categoryData = categoryJson.getJSONObject(category.name)
                        categoryBreakdownMap[category] = NutritionData(
                            calories = categoryData.getInt("calories"),
                            protein = categoryData.getDouble("protein").toFloat(),
                            carbs = categoryData.getDouble("carbs").toFloat(),
                            fat = categoryData.getDouble("fat").toFloat()
                        )
                    }
                }
                
                _dailyStats.value = DailyStats(
                    date = today,
                    totalCalories = totalCalories,
                    totalProtein = totalProtein,
                    totalCarbs = totalCarbs,
                    totalFat = totalFat,
                    mealBreakdown = mealBreakdownMap,
                    categoryBreakdown = categoryBreakdownMap
                )
                return
            } catch (e: Exception) {
                // If there's an error parsing the cached data, continue to generate new data
            }
        }
        
        // In a real app, this would fetch actual data from the repo
        // For example, a complex query to get all nutritional info for today
        val today = Date()
        
        // Sample data with more detailed breakdown
        val breakfastNutrition = NutritionData(350, 15f, 45f, 10f)
        val lunchNutrition = NutritionData(550, 25f, 60f, 20f)
        val dinnerNutrition = NutritionData(650, 30f, 50f, 25f)
        val snacksNutrition = NutritionData(200, 5f, 25f, 5f)
        
        val mealBreakdown = mapOf(
            ViewMealType.BREAKFAST to breakfastNutrition,
            ViewMealType.LUNCH to lunchNutrition,
            ViewMealType.DINNER to dinnerNutrition,
            ViewMealType.SNACK to snacksNutrition
        )
        
        val categoryBreakdown = mapOf(
            FoodCategory.PROTEIN to NutritionData(500, 50f, 5f, 25f),
            FoodCategory.CARBS to NutritionData(600, 15f, 120f, 10f),
            FoodCategory.FRUITS to NutritionData(250, 3f, 30f, 2f),
            FoodCategory.VEGETABLES to NutritionData(150, 5f, 15f, 3f),
            FoodCategory.DAIRY to NutritionData(200, 12f, 6f, 12f),
            FoodCategory.SWEETS to NutritionData(200, 2f, 30f, 8f)
        )
        
        val totalCalories = mealBreakdown.values.sumOf { it.calories }
        val totalProtein = mealBreakdown.values.sumOf { it.protein.toDouble() }.toFloat()
        val totalCarbs = mealBreakdown.values.sumOf { it.carbs.toDouble() }.toFloat()
        val totalFat = mealBreakdown.values.sumOf { it.fat.toDouble() }.toFloat()
        
        val dummyStats = DailyStats(
            date = today,
            totalCalories = totalCalories,
            totalProtein = totalProtein,
            totalCarbs = totalCarbs,
            totalFat = totalFat,
            mealBreakdown = mealBreakdown,
            categoryBreakdown = categoryBreakdown
        )
        
        // Cache the data in SharedPreferences
        cacheDailyStats(dummyStats)
        
        _dailyStats.value = dummyStats
    }
    
    private fun cacheDailyStats(stats: DailyStats) {
        val todayKey = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(stats.date)
        
        val mealBreakdownJson = JSONObject()
        stats.mealBreakdown.forEach { (mealType, nutritionData) ->
            val mealJson = JSONObject().apply {
                put("calories", nutritionData.calories)
                put("protein", nutritionData.protein)
                put("carbs", nutritionData.carbs)
                put("fat", nutritionData.fat)
            }
            mealBreakdownJson.put(mealType.name, mealJson)
        }
        
        val categoryBreakdownJson = JSONObject()
        stats.categoryBreakdown.forEach { (category, nutritionData) ->
            val categoryJson = JSONObject().apply {
                put("calories", nutritionData.calories)
                put("protein", nutritionData.protein)
                put("carbs", nutritionData.carbs)
                put("fat", nutritionData.fat)
            }
            categoryBreakdownJson.put(category.name, categoryJson)
        }
        
        val json = JSONObject().apply {
            put("totalCalories", stats.totalCalories)
            put("totalProtein", stats.totalProtein)
            put("totalCarbs", stats.totalCarbs)
            put("totalFat", stats.totalFat)
            put("mealBreakdown", mealBreakdownJson)
            put("categoryBreakdown", categoryBreakdownJson)
        }
        
        preferences.edit {
            putString("daily_stats_$todayKey", json.toString())
        }
    }
    
    private fun loadWeeklyStats() {
        val startDate = DateUtils.getStartOfWeek()
        val endDate = DateUtils.getEndOfWeek()
        
        // Generate random data for the week
        val dailyCalories = mutableMapOf<Date, Int>()
        val calendar = Calendar.getInstance()
        calendar.time = startDate
        
        while (!calendar.time.after(endDate)) {
            // Create slightly random data with a pattern (higher on weekends)
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            val baseCalories = if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                2200 // Higher calories on weekends
            } else {
                1800 // Lower on weekdays
            }
            
            // Add some randomness (±200 calories)
            val randomOffset = Random.nextInt(-200, 201)  // -200 to 200 inclusive
            val dailyCalorie = baseCalories + randomOffset
            dailyCalories[calendar.time] = dailyCalorie
            
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }
        
        // Calculate averages
        val avgCalories = dailyCalories.values.average().toInt()
        val avgProtein = (avgCalories * 0.25 / 4).toFloat() // 25% of calories from protein
        val avgCarbs = (avgCalories * 0.5 / 4).toFloat() // 50% of calories from carbs
        val avgFat = (avgCalories * 0.25 / 9).toFloat() // 25% of calories from fat
        
        // Mock meal type percentages
        val mealTypePercentages = mapOf(
            ViewMealType.BREAKFAST to 0.2f,
            ViewMealType.LUNCH to 0.35f,
            ViewMealType.DINNER to 0.35f,
            ViewMealType.SNACK to 0.1f
        )
        
        // Mock food category percentages
        val foodCategoryPercentages = mapOf(
            FoodCategory.PROTEIN to 0.25f,
            FoodCategory.CARBS to 0.30f,
            FoodCategory.DAIRY to 0.1f,
            FoodCategory.FRUITS to 0.15f,
            FoodCategory.VEGETABLES to 0.15f,
            FoodCategory.SWEETS to 0.05f
        )
        
        _weeklyStats.value = WeeklyStats(
            startDate = startDate,
            endDate = endDate,
            dailyCalories = dailyCalories,
            averageCalories = avgCalories,
            averageProtein = avgProtein,
            averageCarbs = avgCarbs,
            averageFat = avgFat,
            mealTypePercentages = mealTypePercentages,
            foodCategoryPercentages = foodCategoryPercentages
        )
    }
    
    private fun loadMonthlyStats() {
        val startDate = DateUtils.getStartOfMonth()
        val endDate = DateUtils.getEndOfMonth()
        
        // Generate daily data
        val dailyCalories = mutableMapOf<Date, Int>()
        val calendar = Calendar.getInstance()
        calendar.time = startDate
        
        while (!calendar.time.after(endDate)) {
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            val baseCalories = if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                2200 // Higher calories on weekends
            } else {
                1800 // Lower on weekdays
            }
            
            // Add some randomness (±200 calories)
            val randomOffset = Random.nextInt(-200, 201)  // -200 to 200 inclusive
            val dailyCalorie = baseCalories + randomOffset
            dailyCalories[calendar.time] = dailyCalorie
            
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }
        
        // Generate weekly averages
        val weeklyAverages = mutableListOf<Pair<Date, Int>>()
        calendar.time = startDate
        while (calendar.time <= endDate) {
            val weekStart = calendar.time
            
            // Calculate average for this week
            var weekTotal = 0
            var daysInWeek = 0
            
            for (i in 0..6) {
                val currentDate = calendar.time
                if (!currentDate.after(endDate)) {
                    weekTotal += dailyCalories[currentDate] ?: 0
                    daysInWeek++
                }
                calendar.add(Calendar.DAY_OF_YEAR, 1)
            }
            
            val weekAvg = if (daysInWeek > 0) weekTotal / daysInWeek else 0
            weeklyAverages.add(Pair(weekStart, weekAvg))
        }
        
        // Calculate monthly averages
        val avgCalories = dailyCalories.values.average().toInt()
        val avgProtein = (avgCalories * 0.25 / 4).toFloat()
        val avgCarbs = (avgCalories * 0.5 / 4).toFloat()
        val avgFat = (avgCalories * 0.25 / 9).toFloat()
        
        // Top categories
        val topCategories = listOf(
            Pair(FoodCategory.CARBS, 35),
            Pair(FoodCategory.PROTEIN, 30),
            Pair(FoodCategory.VEGETABLES, 15),
            Pair(FoodCategory.FRUITS, 10),
            Pair(FoodCategory.DAIRY, 5),
            Pair(FoodCategory.SWEETS, 5)
        )
        
        _monthlyStats.value = MonthlyStats(
            startDate = startDate,
            endDate = endDate,
            dailyCalories = dailyCalories,
            weeklyAverages = weeklyAverages,
            monthlyAvgCalories = avgCalories,
            monthlyAvgProtein = avgProtein,
            monthlyAvgCarbs = avgCarbs,
            monthlyAvgFat = avgFat,
            topCategories = topCategories
        )
    }
    
    private fun loadFilteredMealData() {
        val dateRangeValue = _selectedDateRange.value
        val startDate = dateRangeValue?.first ?: DateUtils.getStartOfWeek()
        val endDate = dateRangeValue?.second ?: DateUtils.getEndOfWeek()
        
        val mealType = _selectedMealType.value
        val foodCategory = _selectedFoodCategory.value
        
        // In a real app, you would query the database with these filters
        // For now, generate sample data
        val allMealData = generateSampleMealData(startDate, endDate)
        
        // Apply filters
        val filtered = allMealData.filter { meal ->
            (mealType == null || meal.mealType == mealType) &&
            (foodCategory == null || meal.foodCategory == foodCategory)
        }
        
        _filteredMealData.value = filtered
    }
    
    private fun generateSampleMealData(startDate: Date, endDate: Date): List<MealData> {
        // Instead of generating random data, we should fetch actual food entries
        // from the database for the given date range
        
        val mealData = mutableListOf<MealData>()
        
        // Since we can't directly access the data synchronously (it's in LiveData),
        // we'll need to use a different approach
        
        // Check if we already have cached data for this date range
        val cachedData = getCachedMealData(startDate, endDate)
        if (cachedData.isNotEmpty()) {
            return cachedData
        }
        
        // If no cached data, set up observers for the LiveData
        setupMealDataObservers(startDate, endDate)
        
        // For now, generate minimal placeholder data to avoid empty UI
        val calendar = Calendar.getInstance()
        calendar.time = startDate
        
        val mealTypes = ViewMealType.values()
        
        while (!calendar.time.after(endDate)) {
            val date = calendar.time
            
            // Add minimal entries for each meal type
            for (mealType in mealTypes) {
                // Create minimal nutrition data
                val nutrition = NutritionData(
                    calories = 0,
                    protein = 0f,
                    carbs = 0f,
                    fat = 0f
                )
                
                mealData.add(
                    MealData(
                        date = date,
                        mealType = mealType,
                        nutrition = nutrition,
                        foodCategory = FoodCategory.PROTEIN // Default
                    )
                )
            }
            
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }
        
        return mealData
    }
    
    // Cache for meal data
    private val mealDataCache = mutableMapOf<String, List<MealData>>()
    
    private fun getCachedMealData(startDate: Date, endDate: Date): List<MealData> {
        val cacheKey = "${startDate.time}-${endDate.time}"
        return mealDataCache[cacheKey] ?: emptyList()
    }
    
    private fun setupMealDataObservers(startDate: Date, endDate: Date) {
        // Get food entries for the date range
        val entriesLiveData = foodEntryRepository.getFoodEntriesForDateRange(startDate, endDate)
        
        // Observer to process the entries when they change
        entriesLiveData.observeForever { entries ->
            if (entries != null && entries.isNotEmpty()) {
                processAndCacheFoodEntries(entries, startDate, endDate)
            }
        }
    }
    
    private fun processAndCacheFoodEntries(entries: List<FoodEntry>, startDate: Date, endDate: Date) {
        viewModelScope.launch {
            val mealData = mutableListOf<MealData>()
            
            // Group entries by date and meal type
            val entriesByDateAndMeal = entries.groupBy { entry -> 
                Pair(DateUtils.getStartOfDay(entry.date), convertMealType(entry.mealType)) 
            }
            
            // Process each group
            for (entry in entriesByDateAndMeal.entries) {
                val dateAndMealType = entry.key
                val mealEntries = entry.value
                val date = dateAndMealType.first
                val viewMealType = dateAndMealType.second
                
                // Calculate total nutrition for this meal
                var totalCalories = 0
                var totalProtein = 0f
                var totalCarbs = 0f
                var totalFat = 0f
                
                // Find the dominant food category for this meal
                val categoryCounts = mutableMapOf<FoodCategory, Int>()
                
                // Process each entry in this meal
                for (entry in mealEntries) {
                    // Get the food details from the entry
                    val foodLiveData = database.foodDao().getFoodById(entry.foodId)
                    
                    // We need to get the value from the LiveData - this is simplified for now
                    // In a real app, you would use observe or other means to properly handle LiveData
                    foodLiveData.value?.let { food ->
                        // Calculate nutrition based on servings
                        val servingMultiplier = entry.servings
                        totalCalories += (food.calories * servingMultiplier).toInt()
                        totalProtein += food.protein * servingMultiplier
                        totalCarbs += food.carbs * servingMultiplier
                        totalFat += food.fat * servingMultiplier
                        
                        // Determine food category (simplified example)
                        val category = determineFoodCategory(food)
                        categoryCounts[category] = (categoryCounts[category] ?: 0) + 1
                    }
                }
                
                // Find the dominant category
                var dominantCategory = FoodCategory.PROTEIN // Default if no category determined
                var maxCount = 0
                for (entry in categoryCounts.entries) {
                    if (entry.value > maxCount) {
                        maxCount = entry.value
                        dominantCategory = entry.key
                    }
                }
                
                // Create nutrition data
                val nutrition = NutritionData(
                    calories = totalCalories,
                    protein = totalProtein,
                    carbs = totalCarbs,
                    fat = totalFat
                )
                
                // Add to meal data
                mealData.add(
                    MealData(
                        date = date,
                        mealType = viewMealType,
                        nutrition = nutrition,
                        foodCategory = dominantCategory
                    )
                )
            }
            
            // Cache the processed data
            val cacheKey = "${startDate.time}-${endDate.time}"
            mealDataCache[cacheKey] = mealData
            
            // Update the filtered meal data
            _filteredMealData.value = mealData
        }
    }
    
    // Helper function to convert between model MealType and view MealType
    private fun convertMealType(mealType: MealType): ViewMealType {
        return when (mealType) {
            MealType.BREAKFAST -> ViewMealType.BREAKFAST
            MealType.LUNCH -> ViewMealType.LUNCH
            MealType.DINNER -> ViewMealType.DINNER
            MealType.SNACK -> ViewMealType.SNACK
        }
    }
    
    // Helper method to determine food category based on macronutrient profile
    private fun determineFoodCategory(food: Food): FoodCategory {
        // This is a simplified approach. In a real app, you might have actual food categories
        // stored with the foods or use a more sophisticated algorithm
        
        val totalMacros = food.protein + food.carbs + food.fat
        if (totalMacros == 0f) return FoodCategory.FRUITS // Default
        
        // Determine based on dominant macronutrient
        return when {
            food.protein / totalMacros > 0.4f -> FoodCategory.PROTEIN
            food.carbs / totalMacros > 0.6f -> FoodCategory.CARBS
            food.fat / totalMacros > 0.4f -> FoodCategory.DAIRY // Assuming high fat = dairy for simplicity
            // We don't have enough info to distinguish fruits/vegetables/sweets
            // So just use a default for the rest
            else -> FoodCategory.FRUITS
        }
    }
    
    private fun generateInsights() {
        val insights = mutableListOf<NutritionInsight>()
        
        // Generate insights based on the daily and weekly stats
        val dailyData = _dailyStats.value
        val weeklyData = _weeklyStats.value
        
        if (dailyData != null) {
            // Protein intake insight
            val proteinRatio = dailyData.totalProtein * 4 / dailyData.totalCalories.toFloat()
            if (proteinRatio < 0.15f) {
                insights.add(
                    NutritionInsight(
                        type = InsightType.PROTEIN,
                        title = "Low Protein Intake",
                        description = "Your protein intake today is below recommended levels.",
                        value = proteinRatio * 100,
                        recommendation = "Try adding more lean meats, legumes, or plant-based proteins to your diet."
                    )
                )
            } else if (proteinRatio > 0.3f) {
                insights.add(
                    NutritionInsight(
                        type = InsightType.PROTEIN,
                        title = "High Protein Intake",
                        description = "Your protein intake today is above average.",
                        value = proteinRatio * 100,
                        recommendation = "Consider balancing with more complex carbohydrates and healthy fats."
                    )
                )
            }
            
            // Carb insight
            val carbRatio = dailyData.totalCarbs * 4 / dailyData.totalCalories.toFloat()
            if (carbRatio > 0.6f) {
                insights.add(
                    NutritionInsight(
                        type = InsightType.CARBS,
                        title = "High Carbohydrate Ratio",
                        description = "Your diet today consists of ${(carbRatio * 100).toInt()}% carbohydrates.",
                        value = carbRatio * 100,
                        recommendation = "Consider replacing some simple carbs with more protein or healthy fats."
                    )
                )
            }
            
            // Fat insight
            val fatRatio = dailyData.totalFat * 9 / dailyData.totalCalories.toFloat()
            if (fatRatio > 0.4f) {
                insights.add(
                    NutritionInsight(
                        type = InsightType.FAT,
                        title = "High Fat Consumption",
                        description = "Your fat intake today is on the higher side at ${(fatRatio * 100).toInt()}% of calories.",
                        value = fatRatio * 100,
                        recommendation = "Focus on healthy fats like avocados, nuts, and olive oil rather than saturated fats."
                    )
                )
            }
        }
        
        if (weeklyData != null) {
            // Weekly calorie trend insight
            val calories = weeklyData.dailyCalories.values.toList()
            if (calories.size >= 3) {
                val trend = calories.takeLast(3).average() - calories.take(3).average()
                
                if (trend > 200) {
                    insights.add(
                        NutritionInsight(
                            type = InsightType.CALORIE_TREND,
                            title = "Increasing Calorie Trend",
                            description = "Your calorie intake has been increasing over the week.",
                            value = trend.toFloat(),
                            recommendation = "Monitor your portions and consider adding more low-calorie, high-volume foods."
                        )
                    )
                } else if (trend < -200) {
                    insights.add(
                        NutritionInsight(
                            type = InsightType.CALORIE_TREND,
                            title = "Decreasing Calorie Trend",
                            description = "Your calorie intake has been decreasing over the week.",
                            value = trend.toFloat(),
                            recommendation = "Ensure you're getting enough nutrients with your reduced calories."
                        )
                    )
                }
            }
            
            // Category insight
            var topCategory: FoodCategory? = null
            var topPercentage = 0f
            
            for (entry in weeklyData.foodCategoryPercentages.entries) {
                if (entry.value > topPercentage) {
                    topPercentage = entry.value
                    topCategory = entry.key
                }
            }
            
            if (topCategory != null && topPercentage > 0.35f) {
                insights.add(
                    NutritionInsight(
                        type = InsightType.MEAL_COMPOSITION,
                        title = "Dominant Food Category",
                        description = "${topCategory.displayName} makes up ${(topPercentage * 100).toInt()}% of your diet.",
                        value = topPercentage * 100,
                        recommendation = "Try to diversify your diet with a more balanced mix of food categories."
                    )
                )
            }
        }
        
        // Add a general insight if we have few insights
        if (insights.size < 2) {
            insights.add(
                NutritionInsight(
                    type = InsightType.GENERAL,
                    title = "Balanced Diet",
                    description = "Your overall diet appears balanced. Keep up the good work!",
                    value = 100f,
                    recommendation = "Continue monitoring your intake and try to maintain this balance."
                )
            )
        }
        
        _nutritionInsights.value = insights
    }
}

enum class TimeFrame {
    DAY, WEEK, MONTH, YEAR, CUSTOM
}

enum class ViewMealType(val displayName: String) {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack")
}

enum class FoodCategory(val displayName: String) {
    PROTEIN("Protein"),
    CARBS("Carbohydrates"),
    FRUITS("Fruits"),
    VEGETABLES("Vegetables"),
    DAIRY("Dairy"),
    SWEETS("Sweets & Desserts")
}

enum class InsightType {
    PROTEIN,
    CARBS,
    FAT,
    CALORIE_TREND,
    MEAL_COMPOSITION,
    GENERAL
} 