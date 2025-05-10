package com.bytetrack.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bytetrack.data.AppDatabase
import com.bytetrack.data.model.UserProfile
import com.bytetrack.data.repository.UserProfileRepository
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = AppDatabase.getDatabase(application)
    private val userProfileRepository = UserProfileRepository(database.userProfileDao())
    
    val userProfile: LiveData<UserProfile> = userProfileRepository.userProfile
    
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
} 