package com.bytetrack.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey
    val id: Long = 1, // Single user profile
    val name: String = "",
    val age: Int = 0,
    val gender: String = "",
    val height: Float = 0f, // in cm
    val weight: Float = 0f, // in kg
    val activityLevel: ActivityLevel = ActivityLevel.MODERATE,
    val dailyCalorieGoal: Int = 2000,
    val dailyProteinGoal: Int = 0,
    val dailyCarbsGoal: Int = 0,
    val dailyFatGoal: Int = 0,
    val dailyWaterGoal: Int = 2000, // in ml
    val isPremium: Boolean = false,
    val theme: String = "system" // system, light, dark
)

enum class ActivityLevel {
    SEDENTARY,
    LIGHT,
    MODERATE,
    ACTIVE,
    VERY_ACTIVE
} 