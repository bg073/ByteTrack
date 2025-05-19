package com.bytetrack.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Data class for tracking history of user goals
 */
@Entity(tableName = "goal_history")
data class GoalHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val goalType: String, // CALORIE, WATER, PROTEIN, etc.
    val previousValue: Int,
    val newValue: Int,
    val date: Date,
    val achieved: Boolean = false
) 