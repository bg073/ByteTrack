package com.bytetrack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bytetrack.data.model.UserProfile

@Dao
interface UserProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProfile(userProfile: UserProfile)
    
    @Update
    suspend fun updateUserProfile(userProfile: UserProfile)
    
    @Query("SELECT * FROM user_profile WHERE id = 1")
    fun getUserProfile(): LiveData<UserProfile>
    
    @Query("SELECT * FROM user_profile WHERE id = 1")
    suspend fun getUserProfileSync(): UserProfile?
    
    @Query("SELECT dailyCalorieGoal FROM user_profile WHERE id = 1")
    fun getDailyCalorieGoal(): LiveData<Int>
    
    @Query("SELECT dailyWaterGoal FROM user_profile WHERE id = 1")
    fun getDailyWaterGoal(): LiveData<Int>
    
    @Query("SELECT theme FROM user_profile WHERE id = 1")
    fun getUserTheme(): LiveData<String>
    
    @Query("UPDATE user_profile SET theme = :theme WHERE id = 1")
    suspend fun updateTheme(theme: String)
    
    @Query("UPDATE user_profile SET isPremium = :isPremium WHERE id = 1")
    suspend fun updatePremiumStatus(isPremium: Boolean)
} 