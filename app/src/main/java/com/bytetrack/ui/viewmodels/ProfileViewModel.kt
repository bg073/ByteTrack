package com.bytetrack.ui.viewmodels

import android.app.Application
import android.content.Context
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bytetrack.data.AppDatabase
import com.bytetrack.data.model.GoalHistory
import com.bytetrack.data.model.UserProfile
import com.bytetrack.data.repository.GoalHistoryRepository
import com.bytetrack.data.repository.UserProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.util.Date

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = AppDatabase.getDatabase(application)
    private val userProfileRepository = UserProfileRepository(database.userProfileDao())
    private val goalHistoryRepository = GoalHistoryRepository(database.goalHistoryDao())
    
    private val preferences = application.getSharedPreferences(
        "bytetrack_preferences", Context.MODE_PRIVATE
    )
    
    val userProfile: LiveData<UserProfile> = userProfileRepository.userProfile
    
    // Profile picture URI
    private val _profilePictureUri = MutableLiveData<Uri?>(null)
    val profilePictureUri: LiveData<Uri?> = _profilePictureUri
    
    // Notification preferences
    private val _mealReminderEnabled = MutableLiveData(false)
    val mealReminderEnabled: LiveData<Boolean> = _mealReminderEnabled
    
    private val _waterReminderEnabled = MutableLiveData(false)
    val waterReminderEnabled: LiveData<Boolean> = _waterReminderEnabled
    
    private val _weeklyReportEnabled = MutableLiveData(false)
    val weeklyReportEnabled: LiveData<Boolean> = _weeklyReportEnabled
    
    // Goal history
    private val _goalHistory = MutableLiveData<List<GoalHistory>>(emptyList())
    val goalHistory: LiveData<List<GoalHistory>> = _goalHistory
    
    init {
        loadNotificationPreferences()
        loadProfilePicture()
        loadGoalHistory()
    }
    
    fun updateUserProfile(userProfile: UserProfile) {
        viewModelScope.launch {
            userProfileRepository.updateUserProfile(userProfile)
        }
    }
    
    fun updateTheme(theme: String) {
        viewModelScope.launch {
            userProfileRepository.updateTheme(theme)
        }
    }
    
    fun updatePremiumStatus(isPremium: Boolean) {
        viewModelScope.launch {
            userProfileRepository.updatePremiumStatus(isPremium)
        }
    }
    
    fun setProfilePicture(uri: Uri?) {
        _profilePictureUri.value = uri
        // Store the URI in SharedPreferences
        preferences.edit().putString(PROFILE_PICTURE_KEY, uri?.toString()).apply()
    }
    
    private fun loadProfilePicture() {
        val uriString = preferences.getString(PROFILE_PICTURE_KEY, null)
        _profilePictureUri.value = uriString?.let { Uri.parse(it) }
    }
    
    fun setMealReminderEnabled(enabled: Boolean) {
        _mealReminderEnabled.value = enabled
        preferences.edit().putBoolean(MEAL_REMINDER_KEY, enabled).apply()
    }
    
    fun setWaterReminderEnabled(enabled: Boolean) {
        _waterReminderEnabled.value = enabled
        preferences.edit().putBoolean(WATER_REMINDER_KEY, enabled).apply()
    }
    
    fun setWeeklyReportEnabled(enabled: Boolean) {
        _weeklyReportEnabled.value = enabled
        preferences.edit().putBoolean(WEEKLY_REPORT_KEY, enabled).apply()
    }
    
    private fun loadNotificationPreferences() {
        _mealReminderEnabled.value = preferences.getBoolean(MEAL_REMINDER_KEY, false)
        _waterReminderEnabled.value = preferences.getBoolean(WATER_REMINDER_KEY, false)
        _weeklyReportEnabled.value = preferences.getBoolean(WEEKLY_REPORT_KEY, false)
    }
    
    fun addGoalHistory(goalType: String, previousValue: Int, newValue: Int) {
        viewModelScope.launch {
            val goalHistory = GoalHistory(
                goalType = goalType,
                previousValue = previousValue,
                newValue = newValue,
                date = Date()
            )
            goalHistoryRepository.insertGoalHistory(goalHistory)
            loadGoalHistory()
        }
    }
    
    private fun loadGoalHistory() {
        viewModelScope.launch {
            _goalHistory.value = goalHistoryRepository.getAllGoalHistory()
        }
    }
    
    companion object {
        private const val PROFILE_PICTURE_KEY = "profile_picture_uri"
        private const val MEAL_REMINDER_KEY = "meal_reminder_enabled"
        private const val WATER_REMINDER_KEY = "water_reminder_enabled"
        private const val WEEKLY_REPORT_KEY = "weekly_report_enabled"
    }
} 