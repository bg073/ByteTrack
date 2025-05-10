package com.bytetrack.data.repository

import androidx.lifecycle.LiveData
import com.bytetrack.data.dao.UserProfileDao
import com.bytetrack.data.model.UserProfile

class UserProfileRepository(private val userProfileDao: UserProfileDao) {
    
    val userProfile: LiveData<UserProfile> = userProfileDao.getUserProfile()
    val dailyCalorieGoal: LiveData<Int> = userProfileDao.getDailyCalorieGoal()
    val dailyWaterGoal: LiveData<Int> = userProfileDao.getDailyWaterGoal()
    val userTheme: LiveData<String> = userProfileDao.getUserTheme()
    
    suspend fun getUserProfileSync(): UserProfile {
        return userProfileDao.getUserProfileSync() ?: UserProfile()
    }
    
    suspend fun updateUserProfile(userProfile: UserProfile) {
        userProfileDao.updateUserProfile(userProfile)
    }
    
    suspend fun createUserProfile(userProfile: UserProfile) {
        userProfileDao.insertUserProfile(userProfile)
    }
    
    suspend fun updateTheme(theme: String) {
        userProfileDao.updateTheme(theme)
    }
    
    suspend fun updatePremiumStatus(isPremium: Boolean) {
        userProfileDao.updatePremiumStatus(isPremium)
    }
} 